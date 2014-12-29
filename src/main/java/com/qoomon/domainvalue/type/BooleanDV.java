package com.qoomon.domainvalue.type;

public abstract class BooleanDV extends ComparableDV<Boolean> {

    protected BooleanDV(final Boolean value) {
        super(value);
    }

    /**
     * @param stringValue to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final String stringValue) {
        try {
            Boolean.valueOf(stringValue);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

}
