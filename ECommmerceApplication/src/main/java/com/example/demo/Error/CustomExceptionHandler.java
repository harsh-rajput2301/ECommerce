package com.example.demo.Error;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleCustomException(CustomException ex) {
        // Create a response body, typically in JSON format
        ApiError apiError = new ApiError(ex.getStatus(), ex.getMessage());
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    // A simple inner class to represent the error structure
    @Getter
    private static class ApiError {
        private HttpStatus status;
        private String message;
        private Integer code;

        public ApiError(HttpStatus status, String message) {
            this.status = status;
            this.message = message;
            this.code = status.value();
        }
    }
}
