package com.expenses.app.application.service.impl;

import com.expenses.app.application.service.IAccountService;
import com.expenses.app.application.service.ICategoryService;
import com.expenses.app.application.service.ITransactionService;
import com.expenses.app.domain.exception.BusinessException;
import com.expenses.app.domain.model.Account;
import com.expenses.app.domain.model.Category;
import com.expenses.app.domain.model.Transaction;
import com.expenses.app.domain.repositories.AccountRepository;
import com.expenses.app.domain.repositories.CategoryRepository;
import com.expenses.app.domain.repositories.TransactionRepository;
import com.expenses.app.domain.transactional.TransactionOperationOutputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class TransactionServiceImpl implements ITransactionService {
    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;
    private final AccountRepository accountRepository;
    private final IAccountService accountService;
    private final TransactionOperationOutputPort transactionManager;

    @Override
    public Transaction createTransaction(Transaction transaction) {
        try {
            return transactionManager.doInTransactionWithResult(() -> {
                Category category = categoryRepository.findById(transaction.getCategory().getId())
                        .orElseThrow(() -> new BusinessException("Category not found"));

                Account account = accountRepository.findById(transaction.getAccount().getId())
                        .orElseThrow(() -> new BusinessException("Account not found"));

                transaction.setCategory(category);
                transaction.setAccount(account);

                Transaction createdTransaction = transactionRepository.save(transaction);
                accountService.updateBalance(account, createdTransaction);

                return createdTransaction;
            });

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Transaction updateTransaction(UUID id, Transaction data) {
        try {
            return transactionManager.doInTransactionWithResult(() -> {
                Transaction transaction = transactionRepository.findById(id)
                        .orElseThrow(() -> new BusinessException("Transaction not found"));

                Category category = categoryRepository.findById(data.getCategory().getId())
                        .orElseThrow(() -> new BusinessException("Category not found"));

                BigDecimal oldAmount = transaction.getAmount();

                transaction.setAmount(data.getAmount());
                transaction.setCategory(data.getCategory());
                transaction.setDescription(data.getDescription());
                transaction.setCategory(category);
                transaction.setPaid(data.getPaid());
                transaction.setAmount(data.getAmount());

                return transactionRepository.save(transaction);
            });

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(e.getMessage());
        }
    }
}
