package com.qoomon.domainvalue.type;

public abstract class ByteDV extends ComparableDV<Byte> {

    protected ByteDV(final Byte value) {
        super(value);
    }

    /**
     * @param stringValue to parse
     * @return true if valid, else false
     */
    public static boolean Byte_isValid(final String stringValue) {
        try {
            Byte.valueOf(stringValue);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * @param stringValue to parse
     * @return {@link Byte} object
     */
    public static Byte Byte_of(final String stringValue) {
        assert isValid(stringValue) : isNotValidText(stringValue, Byte.class);
        return Byte.valueOf(stringValue);
    }
}
