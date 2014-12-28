package com.qoomon.domainvalue;

/**
 * @author Bengt Brodersen
 *
 * @param <T> type of the wrapped value
 */
public abstract class SingleFieldDV<T> implements DV {

    /**
     * the wrapped value
     */
    private final T value;

    public SingleFieldDV(final T value) {
        if (value == null) {
            throw new NullPointerException("PrimitiveDV is null");
        }
        this.value = value;
    }

    /**
     * @return the type of the wrapped value
     */
    public abstract Class<T> type();

    /**
     * @param value
     * @return true if value is not null, false else
     */
    public static boolean isValid(Object value) {
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
        result = prime * result
                + ((this.value == null) ? 0 : this.value.hashCode());
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
        final SingleFieldDV<?> other = (SingleFieldDV<?>) obj;
        if (this.value == null) {
            if (other.value != null) {
                return false;
            }
        } else if (!this.value.equals(other.value)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(getClass().getSimpleName())
                .append(" [ ").append(this.value).append(" ]").toString();
    }

}
