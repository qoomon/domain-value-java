package com.qoomon.domainvalue.type;

public abstract class FloatDV extends ComparableDV<Float> {

    protected FloatDV(final Float value) {
        super(value);
    }

    /**
     * @param stringValue to parse
     * @return true if valid, else false
     */
    public static boolean Float_isValid(final String stringValue) {
        try {
            Float.valueOf(stringValue);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * @param stringValue to parse
     * @return {@link Float} object
     */
    public static Float Float_of(final String stringValue) {
        assert isValid(stringValue) : isNotValidText(stringValue, Float.class);
        return Float.valueOf(stringValue);
    }

}
