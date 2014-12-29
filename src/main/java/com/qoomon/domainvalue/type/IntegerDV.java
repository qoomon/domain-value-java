package com.qoomon.domainvalue.type;

public abstract class IntegerDV extends ComparableDV<Integer> {

    protected IntegerDV(final Integer value) {
        super(value);
    }

    protected IntegerDV(final String stringValue) {
        this(Integer.valueOf(stringValue));
    }

    /**
     * @param stringValue to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final String stringValue) {
        try {
            Integer.valueOf(stringValue);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

}
