package com.expenses.app.presentation.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountRequestDTO {
    private String name;
    private BigDecimal initialBalance;
    private BigDecimal currentBalance;
}
