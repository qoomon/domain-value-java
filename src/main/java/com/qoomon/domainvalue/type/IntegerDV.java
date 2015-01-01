package com.qoomon.domainvalue.type;

public abstract class IntegerDV extends ComparableDV<Integer> {

    protected IntegerDV(final Integer value) {
        super(value);
    }

    /**
     * @param stringValue to parse
     * @return true if valid, else false
     */
    public static boolean Integer_isValid(final String stringValue) {
        try {
            Integer.valueOf(stringValue);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * @param stringValue to parse
     * @return {@link java.lang.Integer} object
     */
    public static Integer Integer_of(final String stringValue) {
        assert isValid(stringValue) : isNotValidText(stringValue, Integer.class);
        return Integer.valueOf(stringValue);
    }

}
