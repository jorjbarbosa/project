package com.expenses.app.domain.repositories;

import com.expenses.app.domain.model.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository {
    Optional<Category> findById(UUID id);
    List<Category> findAll();
    Category save(Category category);
    void delete(Category category);
}
