package com.expenses.app.infrastructure.mappers;

import com.expenses.app.domain.model.Category;
import com.expenses.app.infrastructure.persistence.entities.CategoryEntity;
import com.expenses.app.presentation.dto.request.CategoryRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toDomain(CategoryEntity entity);
    CategoryEntity toEntity(Category domain);
    Category fromDTO(CategoryRequestDTO requestDTO);
}
