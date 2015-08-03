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
     * @param stringValue to parse
     * @return true if valid, else false
     */
    public static boolean BigInteger_isValid(final String stringValue) {
        try {
            return isValid(new BigInteger(stringValue));
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * @param stringValue to parse
     * @return {@link BigInteger} object
     */
    public static BigInteger BigInteger_of(final String stringValue) {
        assert isValid(stringValue) : isNotValidText(stringValue, BigInteger.class);
        return new BigInteger(stringValue);
    }
}
