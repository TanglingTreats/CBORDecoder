package com.tanglingtreats.exception;

public class InvalidCBORTypeException extends RuntimeException {
    public InvalidCBORTypeException(String message) {
        super(message);
    }
}
