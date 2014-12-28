package com.qoomon.domainvalue.type;

import com.qoomon.domainvalue.ComparableSingleFieldDV;

import java.math.BigDecimal;

public abstract class BigDecimalDV extends ComparableSingleFieldDV<BigDecimal> {

    protected BigDecimalDV(final BigDecimal value) {
        super(value);
    }

    protected BigDecimalDV(final String stringValue) {
        this(new BigDecimal(stringValue));
    }

    /**
     * @param value to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final BigDecimal value) {
        return ComparableSingleFieldDV.isValid(value);
    }

    /**
     * @param stringValue to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final String stringValue) {
        try {
            BigDecimal value = new BigDecimal(stringValue);
            return isValid(value);
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public Class<BigDecimal> type() {
        return BigDecimal.class;
    }
}
