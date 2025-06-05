package com.expenses.app.domain.repositories;

import com.expenses.app.domain.model.Account;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository {
    Optional<Account> findById(UUID id);
    Account save(Account account);
}
