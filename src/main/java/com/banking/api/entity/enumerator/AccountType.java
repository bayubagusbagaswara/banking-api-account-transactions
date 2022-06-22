package com.banking.api.entity.enumerator;

public enum AccountType {

    SAVINGS("SAVINGS"),
    CHECKING("CHECKING");

    private final String accountType;

    AccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }
}
