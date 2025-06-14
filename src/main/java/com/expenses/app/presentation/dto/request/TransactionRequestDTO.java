package com.expenses.app.presentation.dto.request;

import com.expenses.app.domain.enums.TransactionType;
import com.expenses.app.domain.model.Account;
import com.expenses.app.domain.model.Category;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TransactionRequestDTO {
    private String description;

    private BigDecimal amount;

    private Date date;

    private Boolean paid;

    private TransactionType type;

    private Category category;

    private Account account;
}
