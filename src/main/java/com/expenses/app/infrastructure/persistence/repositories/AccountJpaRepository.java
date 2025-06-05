package com.expenses.app.infrastructure.persistence.repositories;

import com.expenses.app.infrastructure.persistence.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountJpaRepository extends JpaRepository<AccountEntity, UUID> {
}
