package com.qoomon.domainvalue.type;

public abstract class DoubleDV extends ComparableDV<Double> {

    protected DoubleDV(final Double value) {
        super(value);
    }

    protected DoubleDV(final String value) {
        this(Double.valueOf(value));
    }

    protected static boolean isValid(final Double value) {
        return ComparableDV.isValid(value);
    }

    /**
     * @param stringValue to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final String stringValue) {
        try {
            return isValid(Double.valueOf(stringValue));
        } catch (Exception exception) {
            return false;
        }
    }

}
