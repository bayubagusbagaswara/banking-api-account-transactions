package com.banking.api.exception;

public class BalanceTooLowException extends RuntimeException {
    public BalanceTooLowException(String message) {
        super(message);
    }
}
