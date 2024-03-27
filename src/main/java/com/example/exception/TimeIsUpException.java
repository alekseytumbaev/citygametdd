package com.example.exception;

public class TimeIsUpException extends RuntimeException {
    
    public TimeIsUpException(String message) {
        super(message);
     }
}
