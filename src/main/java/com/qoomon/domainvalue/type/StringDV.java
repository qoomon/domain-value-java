package com.qoomon.domainvalue.type;

public abstract class StringDV extends ComparableDV<String> {

    protected StringDV(final String value) {
        super(value);
    }

    protected static boolean isValid(final String value) {
        return ComparableDV.isValid(value);
    }

}
