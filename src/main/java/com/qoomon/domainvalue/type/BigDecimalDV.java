package com.qoomon.domainvalue.type;

import java.math.BigDecimal;

public abstract class BigDecimalDV extends ComparableDV<BigDecimal> {

    protected BigDecimalDV(final BigDecimal value) {
        super(value);
    }

    /**
     * @param stringValue to parse
     * @return true if valid, else false
     */
    public static boolean BigDecimal_isValid(final String stringValue) {
        try {
            new BigDecimal(stringValue);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * @param stringValue to parse
     * @return {@link BigDecimal} object
     */
    public static BigDecimal BigDecimal_of(final String stringValue) {
        assert isValid(stringValue) : isNotValidText(stringValue, BigDecimal.class);
        return new BigDecimal(stringValue);
    }
}
