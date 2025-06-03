package com.expenses.app.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Account {
    private UUID id;
    private String name;
    private BigDecimal initialBalance;
    private BigDecimal currentBalance;
}
