package com.expenses.app.domain.repositories;

import com.expenses.app.domain.model.Transaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionRepository {
    Optional<Transaction> findById(UUID id);
    List<Transaction> findAll();
    Transaction save(Transaction transaction);
    List<Transaction> findByAccountId(UUID accountId);
}
