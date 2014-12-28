package com.qoomon.domainvalue.type;

import com.qoomon.domainvalue.ComparableSingleFieldDV;

public abstract class IntegerDV extends ComparableSingleFieldDV<Integer> {

    protected IntegerDV(final Integer value) {
        super(value);
    }

    protected IntegerDV(final String stringValue) {
        this(Integer.valueOf(stringValue));
    }

    /**
     * @param value to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final Integer value) {
        return ComparableSingleFieldDV.isValid(value);
    }

    /**
     * @param stringValue to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final String stringValue) {
        try {
            Integer value = Integer.valueOf(stringValue);
            return isValid(value);
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public Class<Integer> type() {
        return Integer.class;
    }
}
