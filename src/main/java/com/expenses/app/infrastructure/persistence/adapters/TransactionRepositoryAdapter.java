package com.expenses.app.infrastructure.persistence.adapters;

import com.expenses.app.domain.model.Transaction;
import com.expenses.app.domain.repositories.TransactionRepository;
import com.expenses.app.infrastructure.mappers.TransactionMapper;
import com.expenses.app.infrastructure.persistence.entities.TransactionEntity;
import com.expenses.app.infrastructure.persistence.repositories.TransactionJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TransactionRepositoryAdapter implements TransactionRepository {
    private final TransactionJpaRepository repository;
    private final TransactionMapper mapper;

    @Override
    public Optional<Transaction> findById(UUID id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Transaction> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Transaction save(Transaction transaction) {
        TransactionEntity entity = mapper.toEntity(transaction);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public List<Transaction> findByAccountId(UUID accountId) {
        return repository.findByAccountId(accountId)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

}
