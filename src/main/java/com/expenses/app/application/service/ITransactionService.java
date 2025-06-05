package com.expenses.app.application.service;

import com.expenses.app.domain.model.Transaction;

import java.util.UUID;

public interface ITransactionService {
    Transaction createTransaction(Transaction transaction);
    Transaction updateTransaction(UUID id, Transaction transaction);
}
