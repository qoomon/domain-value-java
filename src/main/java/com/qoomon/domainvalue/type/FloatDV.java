package com.qoomon.domainvalue.type;

public abstract class FloatDV extends ComparableDV<Float> {

    protected FloatDV(final Float value) {
        super(value);
    }

    protected FloatDV(final String stringValue) {
        this(Float.valueOf(stringValue));
    }

    protected static boolean isValid(final Float value) {
        return ComparableDV.isValid(value);
    }

    /**
     * @param stringValue
     *            to wrap
     * @return true if valid, else false
     */
    protected static boolean isValid(final String stringValue) {
        try {
            return isValid(Float.valueOf(stringValue));
        } catch (Exception exception) {
            return false;
        }
    }

}
