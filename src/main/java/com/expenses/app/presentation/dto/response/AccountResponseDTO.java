package com.expenses.app.presentation.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class AccountResponseDTO {
    private UUID id;
    private String name;
    private BigDecimal initialBalance;
    private BigDecimal currentBalance;
}
