package com.example.demo.Exception;

public class ProductDAOException extends RuntimeException {
    public ProductDAOException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ProductDAOException(final String message) {
        super(message);
    }
}