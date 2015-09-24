package com.qoomon.domainvalue.exception;

import com.qoomon.domainvalue.type.DV;

/**
 * Created by qoomon on 03/08/15.
 */
public class InvalidValueException extends DVException {

    private static final long serialVersionUID = 1L;

    private final Class<? extends DV<?>> domainValueType;
    private final Object invalidValue;

    public <T> InvalidValueException(Class<? extends DV<T>> domainValueType, T invalidValue) {
        super(invalidValue + " is NOT a valid value for " + domainValueType.getName());
        this.domainValueType = domainValueType;
        this.invalidValue = invalidValue;
    }

    public Class<? extends DV<?>> getDomainValueType() {
        return this.domainValueType;
    }

    public Object getInvalidValue() {
        return this.invalidValue;
    }

}
