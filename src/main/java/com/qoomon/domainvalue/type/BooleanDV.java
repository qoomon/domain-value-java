package com.qoomon.domainvalue.type;

public abstract class BooleanDV extends ComparableDV<Boolean> {

    protected BooleanDV(final Boolean value) {
        super(value);
    }


    /**
     * @param stringValue to parse
     * @return true if valid, else false
     */
    public static boolean Boolean_isValid(final String stringValue) {
        try {
            Boolean.valueOf(stringValue);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * @param stringValue to parse
     * @return {@link Boolean} object
     */
    public static Boolean Boolean_of(final String stringValue) {
        assert isValid(stringValue) : isNotValidText(stringValue, Boolean.class);
        return Boolean.valueOf(stringValue);
    }
}
