package com.expenses.app.infrastructure.mappers;

import com.expenses.app.domain.model.Account;
import com.expenses.app.infrastructure.persistence.entities.AccountEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account toDomain(AccountEntity entity);
    AccountEntity toEntity(Account domain);
}
