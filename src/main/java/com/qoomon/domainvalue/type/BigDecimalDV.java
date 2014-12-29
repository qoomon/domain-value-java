package com.qoomon.domainvalue.type;

import java.math.BigDecimal;

public abstract class BigDecimalDV extends ComparableDV<BigDecimal> {

    protected BigDecimalDV(final BigDecimal value) {
        super(value);
    }

    /**
     * @param stringValue to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final String stringValue) {
        try {
            new BigDecimal(stringValue);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

}
