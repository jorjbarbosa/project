package com.expenses.app.presentation.controllers;

import com.expenses.app.application.service.ITransactionService;
import com.expenses.app.domain.model.Transaction;
import com.expenses.app.infrastructure.mappers.TransactionMapper;
import com.expenses.app.presentation.dto.request.TransactionRequestDTO;
import com.expenses.app.presentation.dto.response.TransactionResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final ITransactionService transactionService;
    private final TransactionMapper transactionMapper;

    @PostMapping
    public ResponseEntity<TransactionResponseDTO> createTransaction(@RequestBody TransactionRequestDTO request) {
        Transaction transaction = transactionMapper.fromDTO(request);
        transaction = transactionService.createTransaction(transaction);

        return new ResponseEntity<>(transactionMapper.toResponseDTO(transaction), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionResponseDTO> updateTransaction(@PathVariable UUID id, @RequestBody TransactionRequestDTO request) {
        Transaction transaction = transactionMapper.fromDTO(request);
        Transaction updatedTransaction = transactionService.updateTransaction(id, transaction);
        return new ResponseEntity<>(transactionMapper.toResponseDTO(updatedTransaction), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TransactionResponseDTO>> getTransactions() {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponseDTO> getTransaction(@PathVariable UUID id) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TransactionResponseDTO> deleteTransaction(@PathVariable UUID id) {
        return ResponseEntity.ok(null);
    }
}
