package com.qoomon.domainvalue.exception;

/**
 * Created by qoomon on 03/08/15.
 */
public class DVException extends RuntimeException{
    public DVException(String message) {
        super(message);
    }

    public DVException(String message, Throwable cause) {
        super(message, cause);
    }
}
