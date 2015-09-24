package com.qoomon.domainvalue.type;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.WeakHashMap;

import com.qoomon.domainvalue.exception.DVException;
import com.qoomon.domainvalue.exception.InvalidValueException;
import com.qoomon.domainvalue.exception.MethodMissingException;

/**
 * A Domain Value is a single not null value wrapper
 *
 * @param <T>
 *            type of the wrapped value
 * @author Bengt Brodersen
 */
public abstract class DV<T> {

    private static final String IS_VALID_METHOD_NAME = "isValid";
    private static final String OF_METHOD_NAME = "of";

    private static boolean validateOnConstruction = false;

    @SuppressWarnings("rawtypes")
    private static Map<Class<? extends DV>, Method> isValidMethodCache = new WeakHashMap<>();

    @SuppressWarnings("rawtypes")
    private static Map<Class<? extends DV>, Method> ofMethodCache = new WeakHashMap<>();

    @SuppressWarnings("rawtypes")
    private static Map<Class<? extends DV>, Class<?>> valueTypeCache = new WeakHashMap<>();

    static {
        assert validateOnConstruction = true;
    }

    /**
     * the wrapped value
     */
    private final T value;

    /**
     * 
     * @param value
     *            to wrap
     * @require isValid() is true
     */
    @SuppressWarnings("unchecked")
    protected DV(final T value) {
        if (validateOnConstruction && !isValid(this.getClass(), value)) {
            throw new InvalidValueException((Class<? extends DV<T>>) this.getClass(), value);
        }
        this.value = value;
    }

    public static void validateOnConstruction(boolean validateOnConstruction) {
        DV.validateOnConstruction = validateOnConstruction;
    }

    public static <T extends DV<V>, V> void ensureInterface(Class<T> type) {
        isValidMethod(type); // ensure isValid method is present
        ofMethod(type); // ensure of method is present
    }

    public static <T extends DV<V>, V> boolean isValid(Class<T> domainValueType, V value) {
        try {
            return (boolean) isValidMethod(domainValueType).invoke(domainValueType, value);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof DVException) {
                throw (DVException) targetException;
            }
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends DV<V>, V> T of(Class<T> domainValueType, V value) {
        try {
            return (T) ofMethod(domainValueType).invoke(domainValueType, value);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof DVException) {
                throw (DVException) targetException;
            }
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static <T extends DV<V>, V> Method ofMethod(Class<T> domainValueType) {
        Method method = ofMethodCache.get(domainValueType);
        if (method == null) {
            method = method(domainValueType, OF_METHOD_NAME, domainValueType);
        }
        return method;
    }

    private static <T extends DV<V>, V> Method isValidMethod(Class<T> domainValueType) {
        Method method = isValidMethodCache.get(domainValueType);
        if (method == null) {
            method = method(domainValueType, IS_VALID_METHOD_NAME, boolean.class);
        }
        return method;
    }

    private static <T extends DV<V>, V> Method method(Class<T> domainValueType, String domainValueMethodName,
            Class<?> returnType) {
        Class<V> valueType = getValueType(domainValueType);
        Method method = null;
        try {
            method = domainValueType.getMethod(domainValueMethodName, valueType);
        } catch (NoSuchMethodException | SecurityException e) {
        }

        if (method == null
                || !Modifier.isPublic(method.getModifiers())
                || !Modifier.isStatic(method.getModifiers())
                || !method.getReturnType().equals(returnType)) {
            throw new MethodMissingException(domainValueType,
                    "public static " + returnType.getSimpleName() + " " + domainValueMethodName + "(" + valueType.getSimpleName() + ")");
        }

        return method;
    }

    @SuppressWarnings("unchecked")
    public static <T extends DV<V>, V> Class<V> getValueType(Class<T> domainValueType) {
        Class<V> valueType = (Class<V>) valueTypeCache.get(domainValueType);
        if (valueType == null) {
            while (valueType == null && domainValueType != null) {
                Type superType = domainValueType.getGenericSuperclass();
                if (superType instanceof ParameterizedType) {
                    ParameterizedType genericType = (ParameterizedType) superType;
                    valueType = (Class<V>) genericType.getActualTypeArguments()[0];
                } else {
                    domainValueType = (Class<T>) domainValueType.getSuperclass(); // domainValueType.getSuperclass();
                }
            }
            valueTypeCache.put(domainValueType, valueType);
        }
        return valueType;
    }

    /**
     * @param value
     *            to wrap
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
