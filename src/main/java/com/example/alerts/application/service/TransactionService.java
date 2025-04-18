package com.example.alerts.application.service;

import com.example.alerts.application.port.in.TransactionUseCase;
import com.example.alerts.application.port.out.TransactionPort;
import com.example.alerts.domain.model.Transaction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionService implements TransactionUseCase {
    private final TransactionPort transactionPort;

    @Override
    public List<Transaction> getAllTransactions() {
        log.info("Fetching all transactions");
        List<Transaction> transactions = transactionPort.findAllTransactions();
        log.info("Successfully retrieved {} transactions", transactions.size());
        return transactions;
    }
} 