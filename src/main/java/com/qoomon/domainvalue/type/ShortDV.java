package com.qoomon.domainvalue.type;

import com.qoomon.domainvalue.ComparableSingleFieldDV;

public abstract class ShortDV extends ComparableSingleFieldDV<Short> {

    protected ShortDV(final Short value) {
        super(value);
    }

    protected ShortDV(final String stringValue) {
        this(Short.valueOf(stringValue));
    }

    /**
     * @param value
     * @return true if valid, else false
     */
    public static boolean isValid(final Short value) {
        return ComparableSingleFieldDV.isValid(value);
    }

    /**
     * @param stringValue
     * @return true if valid, else false
     */
    public static boolean isValid(final String stringValue) {
        try {
            Short value = Short.valueOf(stringValue);
            return isValid(value);
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public Class<Short> type() {
        return Short.class;
    }
}
