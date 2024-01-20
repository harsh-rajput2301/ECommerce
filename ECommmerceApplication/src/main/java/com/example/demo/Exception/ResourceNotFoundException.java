package com.example.demo.Exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(final String message) {
        super(message);
    }
}