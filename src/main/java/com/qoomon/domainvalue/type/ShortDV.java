package com.qoomon.domainvalue.type;

public abstract class ShortDV extends ComparableDV<Short> {

    protected ShortDV(final Short value) {
        super(value);
    }

    /**
     * @param stringValue to parse
     * @return true if valid, else false
     */
    public static boolean Short_isValid(final String stringValue) {
        try {
            Short.valueOf(stringValue);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * @param stringValue to parse
     * @return {@link Short} object
     */
    public static Short Short_of(final String stringValue) {
        assert isValid(stringValue) : isNotValidText(stringValue, Short.class);
        return Short.valueOf(stringValue);
    }

}
