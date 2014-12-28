package com.qoomon.domainvalue.type;

import com.qoomon.domainvalue.ComparableSingleFieldDV;

public abstract class StringDV extends ComparableSingleFieldDV<String> {

    protected StringDV(final String value) {
        super(value);
    }

    /**
     * @param value to wrap
     * @return true if valid, else false
     */
    public static boolean isValid(final String value) {
        return ComparableSingleFieldDV.isValid(value);
    }

    @Override
    public Class<String> type() {
        return String.class;
    }
}
