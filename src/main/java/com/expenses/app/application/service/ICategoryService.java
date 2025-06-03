package com.expenses.app.application.service;

import com.expenses.app.domain.model.Category;

import java.util.List;
import java.util.UUID;

public interface ICategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(UUID id);
    Category createCategory(Category category);
    Category updateCategory(Category category);
    void deleteCategory(UUID id);
}
