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
     * @param stringValue to parse
     * @return true if valid, else false
     */
    public static boolean Double_isValid(final String stringValue) {
        try {
            return isValid(Double.valueOf(stringValue));
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * @param stringValue to parse
     * @return {@link Double} object
     */
    public static Double Double_of(final String stringValue) {
        assert isValid(stringValue) : isNotValidText(stringValue, Double.class);
        return Double.valueOf(stringValue);
    }

}
