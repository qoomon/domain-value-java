package com.qoomon.domainvalue.type;

import java.math.BigInteger;

public abstract class BigIntegerDV extends ComparableDV<BigInteger> {

    protected BigIntegerDV(final BigInteger value) {
        super(value);
    }

    /**
     * @param stringValue to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final String stringValue) {
        try {
            new BigInteger(stringValue);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

}
