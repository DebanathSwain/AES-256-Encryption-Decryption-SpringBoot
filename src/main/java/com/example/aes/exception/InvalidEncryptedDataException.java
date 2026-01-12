package com.example.aes.exception;

public class InvalidEncryptedDataException extends RuntimeException {

    public InvalidEncryptedDataException(String message) {
        super(message);
    }
}
