package com.qoomon.domainvalue.type;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * A Domain Value is a single not null value wrapper
 *
 * @param <T> type of the wrapped value
 * @author Bengt Brodersen
 */
public abstract class DV<T> {

    /**
     * the wrapped value
     */
    private final T value;

    protected DV(final T value) {
        this.value = value;
    }

    /**
     * @param value to wrap
     * @return true if value is not null, false else
     */
    protected boolean isValid(T value) {
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
