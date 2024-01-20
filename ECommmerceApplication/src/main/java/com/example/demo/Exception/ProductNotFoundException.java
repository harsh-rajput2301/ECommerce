package com.example.demo.Exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ProductNotFoundException(final String message) {
        super(message);
    }
}