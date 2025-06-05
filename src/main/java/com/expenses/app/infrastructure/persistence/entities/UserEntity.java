package com.expenses.app.infrastructure.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "users")
public class UserEntity {
    @Id
    private UUID id;
}
