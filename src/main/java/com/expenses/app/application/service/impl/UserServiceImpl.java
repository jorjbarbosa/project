package com.expenses.app.application.service.impl;

import com.expenses.app.application.service.IUserService;
import com.expenses.app.domain.repositories.UserRepository;

public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
