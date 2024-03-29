package com.example.exception;

public class AmbiguousWinnerException extends RuntimeException {
    
    public AmbiguousWinnerException(String message) {
        super(message);
    }
}
