package com.expenses.app.presentation.controllers;

import com.expenses.app.application.service.IAccountService;
import com.expenses.app.domain.model.Account;
import com.expenses.app.infrastructure.mappers.AccountMapper;
import com.expenses.app.presentation.dto.request.AccountRequestDTO;
import com.expenses.app.presentation.dto.response.AccountResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final IAccountService accountService;
    private final AccountMapper accountMapper;

    @PostMapping
    public ResponseEntity<AccountResponseDTO> createAccount(@RequestBody AccountRequestDTO request) {
        Account account = accountMapper.fromDTO(request);
        account = accountService.createAccount(account);

        return new ResponseEntity<>(accountMapper.toResponseDTO(account), HttpStatus.CREATED);
    }
}
