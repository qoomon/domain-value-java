package com.qoomon.domainvalue.type;

import com.qoomon.domainvalue.ComparableSingleFieldDV;

public abstract class ByteDV extends ComparableSingleFieldDV<Byte> {

    protected ByteDV(final Byte value) {
        super(value);
    }

    protected ByteDV(final String stringValue) {
        this(Byte.valueOf(stringValue));
    }

    /**
     * @param value to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final Byte value) {
        return ComparableSingleFieldDV.isValid(value);
    }

    /**
     * @param stringValue to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final String stringValue) {
        try {
            Byte value = Byte.valueOf(stringValue);
            return isValid(value);
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public Class<Byte> type() {
        return Byte.class;
    }
}
