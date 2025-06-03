package com.expenses.app.application.service.impl;

import com.expenses.app.application.service.ITransactionService;
import com.expenses.app.domain.repositories.TransactionRepository;

public class TransactionServiceImpl implements ITransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
}
