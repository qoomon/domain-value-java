package com.qoomon.domainvalue.type;

import com.qoomon.domainvalue.ComparableSingleFieldDV;

public abstract class LongDV extends ComparableSingleFieldDV<Long> {

    protected LongDV(final Long value) {
        super(value);
    }

    protected LongDV(final String stringValue) {
        this(Long.valueOf(stringValue));
    }

    /**
     * @param value
     * @return true if valid, else false
     */
    public static boolean isValid(final Long value) {
        return ComparableSingleFieldDV.isValid(value);
    }

    /**
     * @param stringValue
     * @return true if valid, else false
     */
    public static boolean isValid(final String stringValue) {
        try {
            Long value = Long.valueOf(stringValue);
            return isValid(value);
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public Class<Long> type() {
        return Long.class;
    }
}
