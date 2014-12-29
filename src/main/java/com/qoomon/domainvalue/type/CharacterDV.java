package com.qoomon.domainvalue.type;

public abstract class CharacterDV extends ComparableDV<Character> {

    protected CharacterDV(final Character value) {
        super(value);
    }

    /**
     * @param stringValue to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final String stringValue) {
        return stringValue != null
                && stringValue.length() == 1;
    }

}
