package com.expenses.app.infrastructure.persistence.entities;

import com.expenses.app.domain.enums.CategoryType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "categories")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private CategoryType type;
}
