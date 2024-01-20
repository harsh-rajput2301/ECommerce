package com.example.demo.Exception;

public class InternalServiceException extends RuntimeException {

    public InternalServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public InternalServiceException(final String message) {
        super(message);
    }
}