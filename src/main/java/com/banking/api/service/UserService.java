package com.banking.api.service;

import com.banking.api.entity.User;

import java.math.BigDecimal;

public interface UserService {
    User depositChecking(User user, BigDecimal amount);
    User depositSavings(User user, BigDecimal amount);
    User withdrawSavings(User user, BigDecimal amount);
    User withdrawChecking(User user, BigDecimal amount);
    double checkSavings(User user);
    double checkChecking(User user);
    void transferToSavings(User user, BigDecimal amount);
    void transferToChecking(User user, BigDecimal amount);
}
