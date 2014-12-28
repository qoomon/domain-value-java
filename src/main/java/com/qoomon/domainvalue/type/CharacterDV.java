package com.qoomon.domainvalue.type;

import com.qoomon.domainvalue.ComparableSingleFieldDV;

public abstract class CharacterDV extends ComparableSingleFieldDV<Character> {

    protected CharacterDV(final Character value) {
        super(value);
    }

    protected CharacterDV(final String stringValue) {
        this(stringValue.charAt(0));
    }

    /**
     * @param value to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final Character value) {
        return ComparableSingleFieldDV.isValid(value);
    }

    /**
     * @param stringValue to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final String stringValue) {
        return stringValue != null
                && stringValue.length() == 1
                && isValid(stringValue.charAt(0));
    }

    @Override
    public Class<Character> type() {
        return Character.class;
    }
}
