package com.banking.api.service.impl;

import com.banking.api.entity.User;
import com.banking.api.exception.UserNotFoundException;
import com.banking.api.repository.UserRepository;
import com.banking.api.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User depositSavings(User user, BigDecimal amount) {
//        user.getAccount().setSavingsBalance(user.getSavingsBalance() + amount);
        User user1 = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new UserNotFoundException(user.getUsername()));
        user1.getAccount().getBalance().add(amount);
        return userRepository.save(user);
    }
    @Override
    public User depositChecking(User user, BigDecimal amount) {
        user.setCheckingBalance(user.getCheckingBalance() + amount);
        return userRepository.save(user);
    }

    @Override
    public User withdrawSavings(User user, BigDecimal amount) {
        user.setSavingsBalance(user.getSavingsBalance() - amount);
        return userRepository.save(user);
    }

    @Override
    public User withdrawChecking(User user, BigDecimal amount) {
        user.setCheckingBalance(user.getCheckingBalance() - amount);
        return userRepository.save(user);
    }

    @Override
    public double checkSavings(User user) {
        return user.getSavingsBalance();
    }

    @Override
    public double checkChecking(User user) {
        return user.getCheckingBalance();
    }

    @Override
    public void transferToSavings(User user, BigDecimal amount) {

    }

    @Override
    public void transferToChecking(User user, BigDecimal amount) {

    }
}
