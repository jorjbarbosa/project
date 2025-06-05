package com.expenses.app.presentation.dto.response;

import com.expenses.app.domain.enums.TransactionType;
import com.expenses.app.domain.model.Account;
import com.expenses.app.domain.model.Category;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
public class TransactionResponseDTO {
    private UUID id;

    private String description;

    private BigDecimal amount;

    private Date date;

    private Boolean paid;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private Category category; // change to dto

    private Account account; // change to dto
}
