package com.qoomon.domainvalue.type;

import com.qoomon.domainvalue.ComparableSingleFieldDV;

public abstract class DoubleDV extends ComparableSingleFieldDV<Double> {

    protected DoubleDV(final Double value) {
        super(value);
    }

    protected DoubleDV(final String stringValue) {
        this(Double.valueOf(stringValue));
    }

    /**
     * @param value
     * @return true if valid, else false
     */
    public static boolean isValid(final Double value) {
        return ComparableSingleFieldDV.isValid(value);
    }

    /**
     * @param stringValue
     * @return true if valid, else false
     */
    public static boolean isValid(final String stringValue) {
        try {
            Double value = Double.valueOf(stringValue);
            return isValid(value);
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public Class<Double> type() {
        return Double.class;
    }
}
