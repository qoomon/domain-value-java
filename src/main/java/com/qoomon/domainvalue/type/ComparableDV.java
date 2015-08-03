package com.qoomon.domainvalue.type;

/**
 * @param <T> type of the wrapped value
 * @author Bengt Brodersen
 */
public abstract class ComparableDV<T extends Comparable<T>>
        extends DV<T>
        implements Comparable<ComparableDV<T>> {

    public ComparableDV(final T value) {
        super(value);
    }

    protected static boolean isValid(final Object value) {
        return DV.isValid(value);
    }

    @Override
    public int compareTo(final ComparableDV<T> obj) {
        return value().compareTo(obj.value());
    }
}
