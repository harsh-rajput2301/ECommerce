package com.example.demo.Exception;

public class UserDAOException extends RuntimeException {
    public UserDAOException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserDAOException(final String message) {
        super(message);
    }
}