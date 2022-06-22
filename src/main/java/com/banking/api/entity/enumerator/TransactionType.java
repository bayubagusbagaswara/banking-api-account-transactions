package com.banking.api.entity.enumerator;

public enum TransactionType {
    WITHDRAWAL(0), DEPOSIT(1), TRANSFER(2), INITIAL_DEPOSIT(3);

    private final int value;
    TransactionType(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}