package com.expenses.app.infrastructure.config;

import com.expenses.app.application.service.IAccountService;
import com.expenses.app.application.service.ICategoryService;
import com.expenses.app.application.service.ITransactionService;
import com.expenses.app.application.service.IUserService;
import com.expenses.app.application.service.impl.AccountServiceImpl;
import com.expenses.app.application.service.impl.CategoryServiceImpl;
import com.expenses.app.application.service.impl.TransactionServiceImpl;
import com.expenses.app.application.service.impl.UserServiceImpl;
import com.expenses.app.domain.repositories.AccountRepository;
import com.expenses.app.domain.repositories.CategoryRepository;
import com.expenses.app.domain.repositories.TransactionRepository;
import com.expenses.app.domain.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    ICategoryService categoryService(CategoryRepository categoryRepository) {
        return new CategoryServiceImpl(categoryRepository);
    }

    @Bean
    ITransactionService transactionService(TransactionRepository transactionRepository) {
        return new TransactionServiceImpl(transactionRepository);
    }

    @Bean
    IAccountService accountService(AccountRepository accountRepository) {
        return new AccountServiceImpl(accountRepository);
    }

    @Bean
    IUserService userService(UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }
}
