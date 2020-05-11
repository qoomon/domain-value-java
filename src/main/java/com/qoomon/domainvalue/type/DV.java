package com.qoomon.domainvalue.type;

import com.qoomon.domainvalue.annotation.FactoryMethod;
import com.qoomon.domainvalue.annotation.ValidationMethod;
import com.qoomon.domainvalue.exception.InvalidAnnotationException;
import com.qoomon.generic.GenericTypeUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * A Domain Value is a single not null value wrapper
 *
 * @param <T> type of the wrapped value
 * @author Bengt Brodersen
 */
public abstract class DV<T> {

    public static final String DEFAULT_VALIDATION_METHOD_NAME = "isValid";
    public static final String DEFAULT_FACTORY_METHOD_NAME = "of";

    private static boolean validateOnConstruction = true;

    private static final Map<Class<? extends DV<?>>, Method> validationMethodCache = new WeakHashMap<>();

    private static final Map<Class<? extends DV<?>>, Method> factoryMethodCache = new WeakHashMap<>();

    private static final Map<Class<? extends DV<?>>, Class<?>> valueTypeCache = new WeakHashMap<>();


    /**
     * the wrapped value
     */
    private final T value;

    /**
     * @param value to wrap
     * @require isValid() is true
     */
    @SuppressWarnings("unchecked")
    protected DV(final T value) {
        if (validateOnConstruction && !isValid(this.getClass(), value)) {
            throw new IllegalArgumentException(this.getClass() + " Invalid value: " + value);
        }
        this.value = value;
    }

    public static void validateOnConstruction(boolean validateOnConstruction) {
        DV.validateOnConstruction = validateOnConstruction;
    }


    public static <T extends DV<V>, V> boolean isValid(Class<T> domainValueType, V value) {
        try {
            return (boolean) validationMethod(domainValueType).invoke(domainValueType, value);
        } catch (InvocationTargetException | IllegalAccessException e) {
            if (e.getCause() instanceof IllegalArgumentException) {
                throw (IllegalArgumentException) e.getCause();
            }
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends DV<V>, V> T of(Class<T> domainValueType, V value) {
        try {
            return (T) factoryMethod(domainValueType).invoke(domainValueType, value);
        } catch (InvocationTargetException | IllegalAccessException e) {
            if (e.getCause() instanceof IllegalArgumentException) {
                throw (IllegalArgumentException) e.getCause();
            }
            throw new RuntimeException(e);
        }
    }

    private static <T extends DV<V>, V> Method factoryMethod(Class<T> domainValueType) {
        Method method = factoryMethodCache.get(domainValueType);
        if (method == null) {
            Class<V> valueType = DV.getValueType(domainValueType);
            method = annotationMethod(domainValueType, FactoryMethod.class);
            if (method == null) {
                method = namedMethod(domainValueType, DEFAULT_FACTORY_METHOD_NAME, valueType);
            }
            if (method == null
                    || !Modifier.isPublic(method.getModifiers())
                    || !Modifier.isStatic(method.getModifiers())
                    || !(method.getParameterTypes().length == 1)
                    || !(method.getParameterTypes()[0] == valueType)
                    || !method.getReturnType().equals(domainValueType)) {
                throw new NoSuchMethodError(" Factory method is missing for " + domainValueType.getName() + "\n"
                        + "  public static " + domainValueType.getName() + " isValid(" + valueType.getName() + ")\n"
                        + "  or\n"
                        + "  @" + FactoryMethod.class.getSimpleName() + " public static " + domainValueType.getName() + " isValid(" + valueType.getName() + ")");
            }
            factoryMethodCache.put(domainValueType, method);
        }
        return method;
    }

    private static <T extends DV<V>, V> Method validationMethod(Class<T> domainValueType) {

        Method method = validationMethodCache.get(domainValueType);
        if (method == null) {
            Class<V> valueType = DV.getValueType(domainValueType);
            method = annotationMethod(domainValueType, ValidationMethod.class);
            if (method == null) {
                method = namedMethod(domainValueType, DEFAULT_VALIDATION_METHOD_NAME, valueType);
            }
            if (method == null
                    || !Modifier.isPublic(method.getModifiers())
                    || !Modifier.isStatic(method.getModifiers())
                    || !(method.getParameterTypes().length == 1)
                    || !(method.getParameterTypes()[0] == valueType)
                    || !method.getReturnType().equals(boolean.class)) {
                throw new NoSuchMethodError(" Validation method is missing for " + domainValueType.getName() + "\n"
                        + "  public static " + boolean.class.getName() + " isValid(" + valueType.getName() + ")\n"
                        + "  or\n"
                        + "  @" + ValidationMethod.class.getSimpleName() + " public static " + boolean.class.getName() + " isValid(" + valueType.getName() + ")");
            }
            validationMethodCache.put(domainValueType, method);
        }
        return method;
    }


    private static <T extends DV<V>, V> Method annotationMethod(final Class<T> valueClass, final Class<? extends Annotation> annotationClass) {

        Method method = null;
        for (Method valueClassMethod : valueClass.getMethods()) {
            if (valueClassMethod.isAnnotationPresent(annotationClass)) {
                if (method != null) {
                    throw new InvalidAnnotationException(valueClass + ": Ambiguous Method Annotation " + annotationClass.getSimpleName());
                }
                method = valueClassMethod;
            }
        }
        return method;
    }

    private static <T extends DV<V>, V> Method namedMethod(final Class<T> valueClass, final String name, final Class<V> valueType) {

        Method method = null;
        for (Method valueClassMethod : valueClass.getMethods()) {
            if (valueClassMethod.getName().equals(name)
                    && valueClassMethod.getParameterTypes().length == 1
                    && valueClassMethod.getParameterTypes()[0] == valueType) {
                method = valueClassMethod;
                break;
            }
        }
        return method;
    }

    @SuppressWarnings("unchecked")
    public static <T extends DV<V>, V> Class<V> getValueType(Class<T> domainValueType) {
        Class<V> valueType = (Class<V>) valueTypeCache.get(domainValueType);
        if (valueType == null) {
            valueType = (Class<V>) GenericTypeUtil.getTypeArguments(DV.class, domainValueType).get(0);
            valueTypeCache.put(domainValueType, valueType);
        }
        return valueType;
    }

    /**
     * @param value to wrap
     * @return true if value is not null, false else
     */
    protected static boolean isValid(Object value) {
        return value != null;
    }

    /**
     * @return the wrapped value
     */
    public T value() {
        return this.value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + value().hashCode();
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DV<?> other = (DV<?>) obj;
        return value().equals(other.value());
    }

    @Override
    public String toString() {
        return value().toString();
    }


}
