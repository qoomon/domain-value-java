package com.qoomon.domainvalue.type;

import com.qoomon.domainvalue.exception.DVException;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * A Domain Value is a single not null value wrapper
 *
 * @param <T> type of the wrapped value
 * @author Bengt Brodersen
 */
public abstract class DV<T> {

    private static Map<Class<? extends DV>, Method> isValidMethodCache = new WeakHashMap<>();

    /**
     * the wrapped value
     */
    private final T value;

    protected DV(final T value) {
        assert validate(value) : value + " is NOT a valid value for " + this.getClass().getName();
        this.value = value;
    }

    private boolean validate(Object value) {
        try {
            Method isValidMethod = isValidMethodCache.get(this.getClass());
            if(isValidMethod == null){
                isValidMethod = this.getClass().getMethod("isValid", value.getClass());
                isValidMethodCache.put(this.getClass(), isValidMethod);
            }
            return (boolean) isValidMethod.invoke(this.getClass(), value);
        } catch (Exception e) {
            throw new DVException(this.getClass().getSimpleName() + ".isValid(" + value.getClass().getSimpleName() + ") failed!", e);
        }
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



    /**
     * @param value to wrap
     * @return true if value is not null, false else
     */
    protected static boolean isValid(Object value) {
        return value != null;
    }

}
