package com.example.alerts.infrastructure.adapter.in.web;

import com.example.alerts.application.port.in.TransactionUseCase;
import com.example.alerts.domain.model.Transaction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
@Slf4j
public class TransactionController {
    private final TransactionUseCase transactionUseCase;

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        log.info("Received request to get all transactions");
        try {
            List<Transaction> transactions = transactionUseCase.getAllTransactions();
            log.info("Successfully retrieved {} transactions", transactions.size());
            return ResponseEntity.ok(transactions);
        } catch (Exception e) {
            log.error("Error while fetching all transactions", e);
            return ResponseEntity.internalServerError().build();
        }
    }
} 