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

    @Override
    protected boolean isValid(T value) {
        return super.isValid(value);
    }

    @Override
    public int compareTo(ComparableDV<T> obj) {
        return value().compareTo(obj.value());
    }
}
