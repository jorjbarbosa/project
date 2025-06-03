package com.expenses.app.infrastructure.mappers;

import com.expenses.app.domain.model.User;
import com.expenses.app.infrastructure.persistence.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toDomain(UserEntity user);
    UserEntity toDomain(User user);
}
