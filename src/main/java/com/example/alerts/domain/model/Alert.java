package com.example.alerts.domain.model;

import lombok.Builder;
import java.time.Instant;

@Builder
public record Alert(
    String alertId,
    String transactionId,
    Severity severity,
    Status status,
    String assignedTo,
    Instant createdAt,
    String description,
    FraudType fraudType
) {
    public enum Severity {
        HIGH, MEDIUM, LOW
    }

    public enum Status {
        NEW, ASSIGNED, IN_PROGRESS, CLOSED
    }

    public enum FraudType {
        ACCOUNT_TAKEOVER("Account Takeover"),
        TRANSACTION_FRAUD("Transaction Fraud"),
        IDENTITY_THEFT("Identity Theft");

        private final String displayName;

        FraudType(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }
} 