package com.qoomon.domainvalue.type;

public abstract class FloatDV extends ComparableDV<Float> {

    protected FloatDV(final Float value) {
        super(value);
    }

    protected FloatDV(final String stringValue) {
        this(Float.valueOf(stringValue));
    }

    /**
     * @param stringValue to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final String stringValue) {
        try {
            Float.valueOf(stringValue);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    protected boolean isValid(Float value) {
        return super.isValid(value);
    }
}
