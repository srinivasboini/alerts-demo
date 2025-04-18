package com.example.alerts.application.port.in;

import com.example.alerts.domain.model.Transaction;
import java.util.List;

public interface TransactionUseCase {
    List<Transaction> getAllTransactions();
} 