package com.expenses.app.presentation.dto.request;

import com.expenses.app.domain.enums.CategoryType;
import lombok.Data;

import java.util.UUID;

@Data
public class CategoryRequestDTO {
    private UUID id;

    private String name;

    private String description;

    private CategoryType type;
}
