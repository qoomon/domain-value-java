package com.qoomon.domainvalue;

/**
 * @param <T> type of the wrapped value
 * @author Bengt Brodersen
 */
public abstract class ComparableSingleFieldDV<T extends Comparable<T>>
        extends SingleFieldDV<T>
        implements Comparable<ComparableSingleFieldDV<T>> {

    public ComparableSingleFieldDV(final T value) {
        super(value);
    }

    /**
     * @param value to wrap
     * @return SingleFieldDV.isValid(value)
     */
    public static boolean isValid(Object value) {
        return SingleFieldDV.isValid(value);
    }

    @Override
    public int compareTo(ComparableSingleFieldDV<T> obj) {
        return value().compareTo(obj.value());
    }
}
