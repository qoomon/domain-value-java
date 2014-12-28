package com.qoomon.domainvalue.type;

import com.qoomon.domainvalue.ComparableSingleFieldDV;

import java.math.BigInteger;

public abstract class BigIntegerDV extends ComparableSingleFieldDV<BigInteger> {

    protected BigIntegerDV(final BigInteger value) {
        super(value);
    }

    protected BigIntegerDV(final String stringValue) {
        this(new BigInteger(stringValue));
    }

    /**
     * @param value to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final BigInteger value) {
        return ComparableSingleFieldDV.isValid(value);
    }

    /**
     * @param stringValue to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final String stringValue) {
        try {
            BigInteger value = new BigInteger(stringValue);
            return isValid(value);
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public Class<BigInteger> type() {
        return BigInteger.class;
    }
}
