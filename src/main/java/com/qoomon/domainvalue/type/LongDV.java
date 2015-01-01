package com.qoomon.domainvalue.type;

public abstract class LongDV extends ComparableDV<Long> {

    protected LongDV(final Long value) {
        super(value);
    }

    /**
     * @param stringValue to parse
     * @return true if valid, else false
     */
    public static boolean Long_isValid(final String stringValue) {
        try {
            Long.valueOf(stringValue);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * @param stringValue to parse
     * @return {@link Long} object
     */
    public static Long Long_of(final String stringValue) {
        assert isValid(stringValue) : isNotValidText(stringValue, Long.class);
        return Long.valueOf(stringValue);
    }

}
