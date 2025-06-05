package com.expenses.app.infrastructure.persistence.adapters;

import com.expenses.app.domain.model.Account;
import com.expenses.app.domain.repositories.AccountRepository;
import com.expenses.app.infrastructure.mappers.AccountMapper;
import com.expenses.app.infrastructure.persistence.entities.AccountEntity;
import com.expenses.app.infrastructure.persistence.repositories.AccountJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AccountRepositoryAdapter implements AccountRepository {
    private final AccountJpaRepository repository;
    private final AccountMapper mapper;

    @Override
    public Optional<Account> findById(UUID id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Account save(Account account) {
        AccountEntity entity = mapper.toEntity(account);
        return mapper.toDomain(repository.save(entity));
    }
}
