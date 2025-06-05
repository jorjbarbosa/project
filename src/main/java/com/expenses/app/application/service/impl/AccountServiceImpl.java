package com.expenses.app.application.service.impl;

import com.expenses.app.application.service.IAccountService;
import com.expenses.app.domain.exception.BusinessException;
import com.expenses.app.domain.model.Account;
import com.expenses.app.domain.model.Transaction;
import com.expenses.app.domain.repositories.AccountRepository;
import com.expenses.app.domain.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;


    @Override
    public Account createAccount(Account account) {
        return this.accountRepository.save(account);
    }

    @Override
    public Account getAccountById(UUID id) {
        return this.accountRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Account not found"));
    }

    @Override
    public void updateBalance(Account account, Transaction transaction) {

        BigDecimal currentBalance = Optional.ofNullable(account.getCurrentBalance())
                .orElse(BigDecimal.ZERO);

        BigDecimal newBalance = currentBalance.add(transaction.getTransactionAmountWithSign());
        account.setCurrentBalance(newBalance);

        accountRepository.save(account);
    }
}
