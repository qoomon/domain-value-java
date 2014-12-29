package com.qoomon.domainvalue.type;

public abstract class ByteDV extends ComparableDV<Byte> {

    protected ByteDV(final Byte value) {
        super(value);
    }

    /**
     * @param stringValue to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final String stringValue) {
        try {
            Byte.valueOf(stringValue);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

}
