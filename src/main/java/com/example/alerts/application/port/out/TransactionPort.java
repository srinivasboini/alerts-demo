package com.example.alerts.application.port.out;

import com.example.alerts.domain.model.Transaction;
import java.util.List;

public interface TransactionPort {
    List<Transaction> findAllTransactions();
} 