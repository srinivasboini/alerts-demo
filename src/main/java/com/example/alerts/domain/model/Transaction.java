package com.example.alerts.domain.model;

import lombok.Builder;
import java.time.Instant;

@Builder
public record Transaction(
    String transactionId,
    String customerId,
    String accountId,
    double amount,
    String currency,
    TransactionType type,
    Status status,
    Instant transactionDate,
    String merchantName,
    String location,
    PaymentMethod paymentMethod
) {
    public enum Status {
        COMPLETED, PENDING, FAILED
    }

    public sealed interface TransactionType permits Purchase, Transfer {
        String description();
    }

    @Builder
    public record Purchase(String description) implements TransactionType {}
    
    @Builder
    public record Transfer(String description) implements TransactionType {}

    public sealed interface PaymentMethod permits CreditCard, DebitCard, BankTransfer, MobilePayment {
        String description();
    }

    @Builder
    public record CreditCard(String description) implements PaymentMethod {}
    
    @Builder
    public record DebitCard(String description) implements PaymentMethod {}
    
    @Builder
    public record BankTransfer(String description) implements PaymentMethod {}
    
    @Builder
    public record MobilePayment(String description) implements PaymentMethod {}
} 