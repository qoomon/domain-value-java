package com.qoomon.domainvalue.exception;

/**
 * Created by qoomon on 03/08/15.
 */
public class DVException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DVException(String message) {
        super(message);
    }

    public DVException(String message, Throwable cause) {
        super(message, cause);
    }

    public DVException(Throwable cause) {
        super(cause);
    }
}
