package com.example.alerts.infrastructure.adapter.out.persistence;

import com.example.alerts.application.port.out.AlertPort;
import com.example.alerts.domain.model.Alert;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@Component
public class AlertPersistenceAdapter implements AlertPort {

    @Override
    public List<Alert> findAllAlerts() {
        return Arrays.asList(
            Alert.builder()
                .alertId("ALERT-2024-001")
                .transactionId("TXN-123456")
                .severity(Alert.Severity.HIGH)
                .status(Alert.Status.NEW)
                .assignedTo("John Doe")
                .createdAt(Instant.parse("2024-03-20T10:30:00Z"))
                .description("Multiple failed login attempts from different locations within a short time period")
                .fraudType(Alert.FraudType.ACCOUNT_TAKEOVER)
                .build(),
            Alert.builder()
                .alertId("ALERT-2024-002")
                .transactionId("TXN-789012")
                .severity(Alert.Severity.MEDIUM)
                .status(Alert.Status.ASSIGNED)
                .assignedTo("Jane Smith")
                .createdAt(Instant.parse("2024-03-20T09:15:00Z"))
                .description("Unusual transaction pattern detected - multiple high-value purchases in different categories")
                .fraudType(Alert.FraudType.TRANSACTION_FRAUD)
                .build(),
            Alert.builder()
                .alertId("ALERT-2024-003")
                .transactionId("TXN-345678")
                .severity(Alert.Severity.LOW)
                .status(Alert.Status.IN_PROGRESS)
                .assignedTo("Mike Johnson")
                .createdAt(Instant.parse("2024-03-19T14:45:00Z"))
                .description("Potential identity verification mismatch during account creation")
                .fraudType(Alert.FraudType.IDENTITY_THEFT)
                .build(),
            Alert.builder()
                .alertId("ALERT-2024-004")
                .transactionId("TXN-901234")
                .severity(Alert.Severity.HIGH)
                .status(Alert.Status.CLOSED)
                .assignedTo("Sarah Wilson")
                .createdAt(Instant.parse("2024-03-19T11:20:00Z"))
                .description("Suspicious account activity with password reset and immediate large transfer")
                .fraudType(Alert.FraudType.ACCOUNT_TAKEOVER)
                .build(),
            Alert.builder()
                .alertId("ALERT-2024-005")
                .transactionId("TXN-567890")
                .severity(Alert.Severity.MEDIUM)
                .status(Alert.Status.NEW)
                .assignedTo("David Brown")
                .createdAt(Instant.parse("2024-03-18T16:30:00Z"))
                .description("Multiple transactions flagged for velocity checking - unusual spending pattern")
                .fraudType(Alert.FraudType.TRANSACTION_FRAUD)
                .build(),
            Alert.builder()
                .alertId("ALERT-2024-006")
                .transactionId("TXN-234567")
                .severity(Alert.Severity.LOW)
                .status(Alert.Status.ASSIGNED)
                .assignedTo("Emily Davis")
                .createdAt(Instant.parse("2024-03-18T13:15:00Z"))
                .description("Potential synthetic identity creation detected")
                .fraudType(Alert.FraudType.IDENTITY_THEFT)
                .build(),
            Alert.builder()
                .alertId("ALERT-2024-007")
                .transactionId("TXN-890123")
                .severity(Alert.Severity.HIGH)
                .status(Alert.Status.IN_PROGRESS)
                .assignedTo("Robert Miller")
                .createdAt(Instant.parse("2024-03-17T15:45:00Z"))
                .description("Account access from known malicious IP address")
                .fraudType(Alert.FraudType.ACCOUNT_TAKEOVER)
                .build(),
            Alert.builder()
                .alertId("ALERT-2024-008")
                .transactionId("TXN-456789")
                .severity(Alert.Severity.MEDIUM)
                .status(Alert.Status.CLOSED)
                .assignedTo("Lisa Anderson")
                .createdAt(Instant.parse("2024-03-17T10:20:00Z"))
                .description("Unusual transaction velocity in high-risk category")
                .fraudType(Alert.FraudType.TRANSACTION_FRAUD)
                .build()
        );
    }
} 