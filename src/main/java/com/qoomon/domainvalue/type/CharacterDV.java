package com.qoomon.domainvalue.type;

public abstract class CharacterDV extends ComparableDV<Character> {

    protected CharacterDV(final Character value) {
        super(value);
    }

    /**
     * @param stringValue to parse
     * @return true if valid, else false
     */
    public static boolean Character_isValid(final String stringValue) {
        return stringValue != null
                && stringValue.length() == 1;
    }

    /**
     * @param stringValue to parse
     * @return {@link Character} object
     */
    public static Character Character_of(final String stringValue) {
        assert isValid(stringValue) : isNotValidText(stringValue, Character.class);
        return stringValue.charAt(0);
    }

}
