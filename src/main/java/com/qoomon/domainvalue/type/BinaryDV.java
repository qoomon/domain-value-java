package com.qoomon.domainvalue.type;

public abstract class BinaryDV extends DV<byte[]> {

    protected BinaryDV(final byte[] value) {
        super(value);
    }

    protected BinaryDV(final String value) {
        this(value.getBytes());
    }

    protected static boolean isValid(byte[] value) {
        return DV.isValid(value) && value.length > 0;
    }

    /**
     * @param stringValue to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final String stringValue) {
        return stringValue != null && isValid(stringValue.getBytes());
    }

}
