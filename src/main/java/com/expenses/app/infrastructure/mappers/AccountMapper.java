package com.expenses.app.infrastructure.mappers;

import com.expenses.app.domain.model.Account;
import com.expenses.app.infrastructure.persistence.entities.AccountEntity;
import com.expenses.app.presentation.dto.request.AccountRequestDTO;
import com.expenses.app.presentation.dto.response.AccountResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account toDomain(AccountEntity entity);
    AccountEntity toEntity(Account domain);
    Account fromDTO(AccountRequestDTO request);
    AccountResponseDTO toResponseDTO(Account domain);
}
