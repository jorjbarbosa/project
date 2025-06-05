package com.expenses.app.domain.transactional;

@FunctionalInterface
public interface TransactionRunnableWithResult<R> {
    R run();
}
