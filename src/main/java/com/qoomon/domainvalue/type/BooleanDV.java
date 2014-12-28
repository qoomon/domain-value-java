package com.qoomon.domainvalue.type;

import com.qoomon.domainvalue.ComparableSingleFieldDV;

public abstract class BooleanDV extends ComparableSingleFieldDV<Boolean> {

    protected BooleanDV(final Boolean value) {
        super(value);
    }

    protected BooleanDV(final String stringValue) {
        this(Boolean.valueOf(stringValue));
    }

    /**
     * @param value to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final Boolean value) {
        return ComparableSingleFieldDV.isValid(value);
    }

    /**
     * @param stringValue to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final String stringValue) {
        try {
            Boolean value = Boolean.valueOf(stringValue);
            return isValid(value);
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public Class<Boolean> type() {
        return Boolean.class;
    }
}
