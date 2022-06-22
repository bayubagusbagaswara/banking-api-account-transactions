package com.banking.api.service.impl;

import com.banking.api.entity.Account;
import com.banking.api.service.AccountService;
import com.banking.api.repository.AccountRepository;
import com.banking.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {

//    @PersistenceContext
//    private EntityManager em;

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> findByUser(User user) {
        return accountRepository.findByUserId(user.getId());
    }
}
