package com.qoomon.domainvalue.type;

import com.qoomon.domainvalue.SingleFieldDV;

public abstract class BinaryDV extends SingleFieldDV<byte[]> {

    protected BinaryDV(final byte[] value) {
        super(value);
    }

    /**
     * @param value
     * @return true if valid, else false
     */
    public static boolean isValid(final byte[] value) {
        return SingleFieldDV.isValid(value);
    }

    @Override
    public Class<byte[]> type() {
        return byte[].class;
    }

}
