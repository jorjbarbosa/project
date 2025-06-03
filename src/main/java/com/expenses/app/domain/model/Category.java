package com.expenses.app.domain.model;

import com.expenses.app.domain.enums.CategoryType;

import java.util.UUID;

public class Category {
    private UUID id;
    private String name;
    private String description;
    private CategoryType type;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryType getType() {
        return type;
    }

    public void setType(CategoryType type) {
        this.type = type;
    }
}
