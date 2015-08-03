package com.qoomon.domainvalue.type;

import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class BigIntegerDV extends ComparableDV<BigInteger> {

    protected BigIntegerDV(final BigInteger value) {
        super(value);
    }

    protected BigIntegerDV(final String stringValue) {
        this(new BigInteger(stringValue));
    }

    protected static boolean isValid(final BigInteger value) {
        return ComparableDV.isValid(value);
    }

    /**
     * @param stringValue to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final String stringValue) {
        try {
            return isValid(new BigInteger(stringValue));
        } catch (Exception exception) {
            return false;
        }
    }

}
