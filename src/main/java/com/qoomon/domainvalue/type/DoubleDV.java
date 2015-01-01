package com.qoomon.domainvalue.type;

public abstract class DoubleDV extends ComparableDV<Double> {

    protected DoubleDV(final Double value) {
        super(value);
    }

    /**
     * @param stringValue to parse
     * @return true if valid, else false
     */
    public static boolean Double_isValid(final String stringValue) {
        try {
            Double.valueOf(stringValue);
            return true;
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
