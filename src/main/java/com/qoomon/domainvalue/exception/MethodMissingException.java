package com.qoomon.domainvalue.exception;

import com.qoomon.domainvalue.type.DV;

/**
 * Created by qoomon on 03/08/15.
 */
public class MethodMissingException extends DVException {

    private static final long serialVersionUID = 1L;

    private final Class<? extends DV<?>> domainValueType;
    private final String missingMethod;

    public <T> MethodMissingException(Class<? extends DV<T>> domainValueType, String missingMethod) {
        super(missingMethod + " is missing for " + domainValueType.getName());
        this.domainValueType = domainValueType;
        this.missingMethod = missingMethod;
    }

    public Class<? extends DV<?>> getDomainValueType() {
        return this.domainValueType;
    }

    public String getMissingMethod() {
        return this.missingMethod;
    }

}
