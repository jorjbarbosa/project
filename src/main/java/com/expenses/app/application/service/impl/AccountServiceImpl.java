package com.expenses.app.application.service.impl;

import com.expenses.app.application.service.IAccountService;
import com.expenses.app.domain.repositories.AccountRepository;

public class AccountServiceImpl implements IAccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
