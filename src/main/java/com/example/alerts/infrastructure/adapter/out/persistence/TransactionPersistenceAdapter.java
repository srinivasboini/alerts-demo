package com.example.alerts.infrastructure.adapter.out.persistence;

import com.example.alerts.application.port.out.TransactionPort;
import com.example.alerts.domain.model.Transaction;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@Component
public class TransactionPersistenceAdapter implements TransactionPort {

    @Override
    public List<Transaction> findAllTransactions() {
        return Arrays.asList(
            Transaction.builder()
                .transactionId("TXN-123456")
                .customerId("CUST-001")
                .accountId("ACC-001")
                .amount(1500.00)
                .currency("USD")
                .type(new Transaction.Purchase("PURCHASE"))
                .status(Transaction.Status.COMPLETED)
                .transactionDate(Instant.parse("2024-03-20T10:30:00Z"))
                .merchantName("Amazon")
                .location("New York, USA")
                .paymentMethod(new Transaction.CreditCard("CREDIT_CARD"))
                .build(),
            Transaction.builder()
                .transactionId("TXN-789012")
                .customerId("CUST-002")
                .accountId("ACC-002")
                .amount(250.50)
                .currency("EUR")
                .type(new Transaction.Purchase("PURCHASE"))
                .status(Transaction.Status.COMPLETED)
                .transactionDate(Instant.parse("2024-03-20T09:15:00Z"))
                .merchantName("Apple Store")
                .location("London, UK")
                .paymentMethod(new Transaction.DebitCard("DEBIT_CARD"))
                .build(),
            Transaction.builder()
                .transactionId("TXN-345678")
                .customerId("CUST-003")
                .accountId("ACC-003")
                .amount(75.25)
                .currency("GBP")
                .type(new Transaction.Purchase("PURCHASE"))
                .status(Transaction.Status.PENDING)
                .transactionDate(Instant.parse("2024-03-19T14:45:00Z"))
                .merchantName("Tesco")
                .location("Manchester, UK")
                .paymentMethod(new Transaction.CreditCard("CREDIT_CARD"))
                .build(),
            Transaction.builder()
                .transactionId("TXN-901234")
                .customerId("CUST-004")
                .accountId("ACC-004")
                .amount(500.00)
                .currency("USD")
                .type(new Transaction.Transfer("TRANSFER"))
                .status(Transaction.Status.COMPLETED)
                .transactionDate(Instant.parse("2024-03-19T11:20:00Z"))
                .merchantName("Bank Transfer")
                .location("Online")
                .paymentMethod(new Transaction.BankTransfer("BANK_TRANSFER"))
                .build(),
            Transaction.builder()
                .transactionId("TXN-567890")
                .customerId("CUST-005")
                .accountId("ACC-005")
                .amount(1200.75)
                .currency("EUR")
                .type(new Transaction.Purchase("PURCHASE"))
                .status(Transaction.Status.COMPLETED)
                .transactionDate(Instant.parse("2024-03-18T16:30:00Z"))
                .merchantName("Booking.com")
                .location("Online")
                .paymentMethod(new Transaction.CreditCard("CREDIT_CARD"))
                .build(),
            Transaction.builder()
                .transactionId("TXN-234567")
                .customerId("CUST-006")
                .accountId("ACC-006")
                .amount(45.00)
                .currency("GBP")
                .type(new Transaction.Purchase("PURCHASE"))
                .status(Transaction.Status.COMPLETED)
                .transactionDate(Instant.parse("2024-03-18T13:15:00Z"))
                .merchantName("Starbucks")
                .location("London, UK")
                .paymentMethod(new Transaction.MobilePayment("MOBILE_PAYMENT"))
                .build(),
            Transaction.builder()
                .transactionId("TXN-890123")
                .customerId("CUST-007")
                .accountId("ACC-007")
                .amount(300.25)
                .currency("USD")
                .type(new Transaction.Purchase("PURCHASE"))
                .status(Transaction.Status.COMPLETED)
                .transactionDate(Instant.parse("2024-03-17T15:45:00Z"))
                .merchantName("Best Buy")
                .location("Chicago, USA")
                .paymentMethod(new Transaction.CreditCard("CREDIT_CARD"))
                .build(),
            Transaction.builder()
                .transactionId("TXN-456789")
                .customerId("CUST-008")
                .accountId("ACC-008")
                .amount(85.50)
                .currency("EUR")
                .type(new Transaction.Purchase("PURCHASE"))
                .status(Transaction.Status.COMPLETED)
                .transactionDate(Instant.parse("2024-03-17T10:20:00Z"))
                .merchantName("IKEA")
                .location("Paris, France")
                .paymentMethod(new Transaction.DebitCard("DEBIT_CARD"))
                .build()
        );
    }
} 