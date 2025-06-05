package com.expenses.app.infrastructure.mappers;

import com.expenses.app.domain.model.Transaction;
import com.expenses.app.infrastructure.persistence.entities.TransactionEntity;
import com.expenses.app.presentation.dto.request.TransactionRequestDTO;
import com.expenses.app.presentation.dto.response.TransactionResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    Transaction toDomain(TransactionEntity entity);
    TransactionEntity toEntity(Transaction domain);
    Transaction fromDTO(TransactionRequestDTO dto);
    TransactionResponseDTO toResponseDTO(Transaction domain);
}
