package com.expenses.app.application.service;

import com.expenses.app.domain.model.Account;
import com.expenses.app.domain.model.Transaction;

import java.util.UUID;

public interface IAccountService {
    Account createAccount(Account account);
    Account getAccountById(UUID id);
    void updateBalance(Account account, Transaction transaction);
}
