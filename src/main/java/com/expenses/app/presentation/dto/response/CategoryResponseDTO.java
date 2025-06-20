package com.expenses.app.presentation.dto.response;

import com.expenses.app.domain.enums.CategoryType;
import lombok.Data;

import java.util.UUID;

@Data
public class CategoryResponseDTO {
    private UUID id;

    private String name;

    private String description;

    private CategoryType type;
}
