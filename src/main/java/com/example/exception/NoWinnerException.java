package com.example.exception;

public class NoWinnerException extends RuntimeException {

    public NoWinnerException(String message) {
        super(message);
    }
}
