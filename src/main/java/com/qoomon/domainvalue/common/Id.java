package com.qoomon.domainvalue.common;

import com.qoomon.domainvalue.type.LongDV;

/**
 * Created by qoomon on 29/12/14.
 */
public class Id extends LongDV {

    protected Id(Long value) {
        super(value);
    }

    public static Id of(Long value) {
        assert isValid(value) : isNotValidText(value, Id.class);
        return new Id(value);
    }

    public static boolean isValid(Long value) {
        return LongDV.isValid(value)
                && value > 0;
    }

    public static Id of(String stringValue) {
        Long value = Long_of(stringValue);
        return of(value);
    }

    public static boolean isValid(String stringValue) {
        if(Long_isValid(stringValue)){
            Long value = Long_of(stringValue);
            return isValid(value);
        }
        return false;
    }

}
