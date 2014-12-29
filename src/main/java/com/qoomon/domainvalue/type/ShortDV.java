package com.qoomon.domainvalue.type;

public abstract class ShortDV extends ComparableDV<Short> {

    protected ShortDV(final Short value) {
        super(value);
    }

    /**
     * @param stringValue to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final String stringValue) {
        try {
            Short.valueOf(stringValue);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

}
