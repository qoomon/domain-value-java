package com.qoomon.domainvalue.type;

import java.math.BigDecimal;

public abstract class BigDecimalDV extends ComparableDV<BigDecimal> {

    protected BigDecimalDV(final BigDecimal value) {
        super(value);
    }

    protected BigDecimalDV(final String stringValue) {
        this(new BigDecimal(stringValue));
    }

    protected static boolean isValid(final BigDecimal value) {
        return ComparableDV.isValid(value);
    }

    /**
     * @param stringValue
     *            to parse
     * @return true if valid, else false
     */
    public static boolean isValid(final String stringValue) {
        try {
            return isValid(new BigDecimal(stringValue));
        } catch (Exception exception) {
            return false;
        }
    }
}
