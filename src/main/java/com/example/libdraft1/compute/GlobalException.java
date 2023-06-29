package com.example.libdraft1.compute;

public class GlobalException extends Exception {
    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(String message, Throwable cause) {
        super(message, cause);
    }
}
