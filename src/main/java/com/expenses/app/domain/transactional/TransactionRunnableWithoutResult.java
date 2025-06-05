package com.expenses.app.domain.transactional;

@FunctionalInterface
public interface TransactionRunnableWithoutResult {
    void run();
}