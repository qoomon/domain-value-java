package com.qoomon.domainvalue.type;

public abstract class BooleanDV extends ComparableDV<Boolean> {

    protected BooleanDV(final Boolean value) {
        super(value);
    }

    protected BooleanDV(final String value) {
        this(Boolean.valueOf(value));
    }

    protected static boolean isValid(final Boolean value) {
        return ComparableDV.isValid(value);
    }

    /**
     * @param stringValue to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final String stringValue) {
        try {
            return isValid(Boolean.valueOf(stringValue));
        } catch (Exception exception) {
            return false;
        }
    }

}
