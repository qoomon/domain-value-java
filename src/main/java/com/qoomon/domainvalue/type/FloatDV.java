package com.qoomon.domainvalue.type;

import com.qoomon.domainvalue.ComparableSingleFieldDV;

public abstract class FloatDV extends ComparableSingleFieldDV<Float> {

    protected FloatDV(final Float value) {
        super(value);
    }

    protected FloatDV(final String stringValue) {
        this(Float.valueOf(stringValue));
    }

    /**
     * @param value to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final Float value) {
        return ComparableSingleFieldDV.isValid(value);
    }

    /**
     * @param stringValue to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final String stringValue) {
        try {
            Float value = Float.valueOf(stringValue);
            return isValid(value);
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public Class<Float> type() {
        return Float.class;
    }
}
