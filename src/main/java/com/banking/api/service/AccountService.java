package com.banking.api.service;

import com.banking.api.entity.Account;
import com.banking.api.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AccountService {

    Account save(Account account) throws Exception;
    List<Account> findByUser(User user);
}
