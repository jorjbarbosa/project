package com.expenses.app.infrastructure.persistence.adapters;

import com.expenses.app.domain.model.Category;
import com.expenses.app.domain.repositories.CategoryRepository;
import com.expenses.app.infrastructure.mappers.CategoryMapper;
import com.expenses.app.infrastructure.persistence.entities.CategoryEntity;
import com.expenses.app.infrastructure.persistence.repositories.CategoryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CategoryRepositoryAdapter implements CategoryRepository {
    private final CategoryJpaRepository repository;
    private final CategoryMapper categoryMapper;

    @Override
    public Optional<Category> findById(UUID id) {
        return repository.findById(id).map(categoryMapper::toDomain);
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll()
                .stream()
                .map(categoryMapper::toDomain)
                .toList();
    }

    @Override
    public Category save(Category category) {
        CategoryEntity entity = categoryMapper.toEntity(category);
        return categoryMapper.toDomain(repository.save(entity));
    }

    @Override
    public void delete(Category category) {

    }


}
