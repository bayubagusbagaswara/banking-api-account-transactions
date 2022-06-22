package com.banking.api.service;

import com.banking.api.entity.Transaction;

import java.util.List;

public interface TransactionService{
    Transaction save(Transaction transaction) throws Exception;
    List<Transaction> findAllByCreatedBy(String username);
}
