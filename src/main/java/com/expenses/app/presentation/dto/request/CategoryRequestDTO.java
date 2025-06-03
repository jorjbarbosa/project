package com.expenses.app.presentation.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class CategoryRequestDTO {
    private UUID id;
    private String name;
}
