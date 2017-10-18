package com.qoomon.domainvalue.type;

public abstract class CharacterDV extends ComparableDV<Character> {

    protected CharacterDV(final Character value) {
        super(value);
    }

    protected CharacterDV(final String value) {
        this(value.charAt(0));
    }

    protected static boolean isValid(final Character value) {
        return ComparableDV.isValid(value);
    }

    /**
     * @param stringValue
     *            to wrap
     * @return true if valid, else false
     */
    protected static boolean isValid(final String stringValue) {
        return stringValue != null && stringValue.length() == 1
                && isValid(stringValue.charAt(0));
    }

}
