package com.expenses.app.presentation.dto.response;

import lombok.Data;

import java.util.UUID;

@Data
public class CategoryResponseDTO {
    private UUID id;
    private String name;
}
