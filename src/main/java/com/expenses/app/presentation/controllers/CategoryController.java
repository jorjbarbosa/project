package com.expenses.app.presentation.controllers;

import com.expenses.app.application.service.ICategoryService;
import com.expenses.app.domain.model.Category;
import com.expenses.app.infrastructure.mappers.CategoryMapper;
import com.expenses.app.presentation.dto.request.CategoryRequestDTO;
import com.expenses.app.presentation.dto.response.CategoryResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    private final ICategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody final CategoryRequestDTO request) {
        Category category = categoryMapper.fromDTO(request);
        Category createdCategory = this.categoryService.createCategory(category);
        return new ResponseEntity<>(categoryMapper.toResponseDTO(createdCategory), HttpStatus.CREATED);
    }
}
