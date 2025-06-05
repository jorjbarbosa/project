package com.expenses.app.application.service.impl;

import com.expenses.app.application.service.ICategoryService;
import com.expenses.app.domain.exception.BusinessException;
import com.expenses.app.domain.model.Category;
import com.expenses.app.domain.repositories.CategoryRepository;

import java.util.List;
import java.util.UUID;

public class CategoryServiceImpl implements ICategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(UUID id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Category not found"));
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return null;
    }

    @Override
    public void deleteCategory(UUID id) {

    }
}
