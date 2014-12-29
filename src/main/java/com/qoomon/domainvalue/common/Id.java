package com.qoomon.domainvalue.common;

import com.qoomon.domainvalue.type.DV;
import com.qoomon.domainvalue.type.LongDV;

/**
 * Created by qoomon on 29/12/14.
 */
public class Id extends LongDV {

    protected Id(Long value) {
        super(value);
    }

    public static boolean validate(Long value) {
        return DV.validate(value, Long.class, Id.class);
    }

    public static Id of(Long value) {
        return DV.of(value, Long.class, Id.class);
    }

    @Override
    protected boolean isValid(Long value) {
        return super.isValid(value)
                && value > 0;
    }

}
