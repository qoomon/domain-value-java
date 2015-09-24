package com.qoomon.domainvalue.common;

import com.qoomon.domainvalue.type.LongDV;

/**
 * Created by qoomon on 29/12/14.
 */
public class Id extends LongDV {

    protected Id(Long value) {
        super(value);
    }

    static Id of(Long value) {
        return new Id(value);
    }

    public static boolean isValid(Long value) {
        return LongDV.isValid(value)
                && value > 0;
    }

}
