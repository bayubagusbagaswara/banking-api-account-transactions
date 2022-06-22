package com.banking.api.service.impl;

import com.banking.api.entity.Transaction;
import com.banking.api.repository.TransactionRepository;
import com.banking.api.service.TransactionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction save(Transaction transaction) throws Exception {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> findAllByCreatedBy(String username) {
        return transactionRepository.findByCreatedBy(username);
    }
}
