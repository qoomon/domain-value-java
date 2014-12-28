package com.qoomon.domainvalue;

/**
 * @author Bengt Brodersen
 *
 * @param <T>
 *            type of the wrapped value
 */
public abstract class ComparableSingleFieldDV<T extends Comparable<T>>
        extends SingleFieldDV<T>
        implements Comparable<ComparableSingleFieldDV<T>>
{

	public ComparableSingleFieldDV(final T value) {
		super(value);
	}

    /**
     * @param value
     * @return SingleFieldDV.isValid(value)
     */
    public static boolean isValid(Object value){
        return SingleFieldDV.isValid(value);
    }

    @Override
    public int compareTo(ComparableSingleFieldDV<T> obj) {
        if(obj == null){
            throw new NullPointerException("compare obj must not null");
        }
        return value().compareTo(obj.value());
    }
}
