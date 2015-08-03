package com.qoomon.domainvalue.type;

public abstract class ShortDV extends ComparableDV<Short> {

    protected ShortDV(final Short value) {
        super(value);
    }

    protected ShortDV(final String value) {
        this(Short.valueOf(value));
    }

    protected static boolean isValid(final Short value) {
        return ComparableDV.isValid(value);
    }

    /**
     * @param stringValue to parse
     * @return true if valid, else false
     */
    public static boolean isValid(final String stringValue) {
        try {
            return isValid(Short.valueOf(stringValue));
        } catch (Exception exception) {
            return false;
        }
    }

}
