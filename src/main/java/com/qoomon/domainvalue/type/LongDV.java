package com.qoomon.domainvalue.type;

public abstract class LongDV extends ComparableDV<Long> {

    protected LongDV(final Long value) {
        super(value);
    }

    /**
     * @param stringValue to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final String stringValue) {
        try {
            Long.valueOf(stringValue);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

}
