package com.example.alerts.domain.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class AlertTest {

    @Test
    void shouldCreateAlertWithBuilder() {
        Alert alert = Alert.builder()
                .alertId("ALERT-001")
                .transactionId("TXN-001")
                .severity(Alert.Severity.HIGH)
                .status(Alert.Status.NEW)
                .assignedTo("John Doe")
                .createdAt(Instant.now())
                .description("Test alert")
                .fraudType(Alert.FraudType.ACCOUNT_TAKEOVER)
                .build();

        assertNotNull(alert);
        assertEquals("ALERT-001", alert.alertId());
        assertEquals("TXN-001", alert.transactionId());
        assertEquals(Alert.Severity.HIGH, alert.severity());
        assertEquals(Alert.Status.NEW, alert.status());
        assertEquals("John Doe", alert.assignedTo());
        assertEquals("Test alert", alert.description());
        assertEquals(Alert.FraudType.ACCOUNT_TAKEOVER, alert.fraudType());
    }

    @ParameterizedTest
    @EnumSource(Alert.Severity.class)
    void shouldSupportAllSeverityLevels(Alert.Severity severity) {
        Alert alert = Alert.builder()
                .alertId("ALERT-001")
                .transactionId("TXN-001")
                .severity(severity)
                .status(Alert.Status.NEW)
                .assignedTo("John Doe")
                .createdAt(Instant.now())
                .description("Test alert")
                .fraudType(Alert.FraudType.ACCOUNT_TAKEOVER)
                .build();

        assertEquals(severity, alert.severity());
    }

    @ParameterizedTest
    @EnumSource(Alert.Status.class)
    void shouldSupportAllStatusValues(Alert.Status status) {
        Alert alert = Alert.builder()
                .alertId("ALERT-001")
                .transactionId("TXN-001")
                .severity(Alert.Severity.HIGH)
                .status(status)
                .assignedTo("John Doe")
                .createdAt(Instant.now())
                .description("Test alert")
                .fraudType(Alert.FraudType.ACCOUNT_TAKEOVER)
                .build();

        assertEquals(status, alert.status());
    }

    @ParameterizedTest
    @EnumSource(Alert.FraudType.class)
    void shouldSupportAllFraudTypes(Alert.FraudType fraudType) {
        Alert alert = Alert.builder()
                .alertId("ALERT-001")
                .transactionId("TXN-001")
                .severity(Alert.Severity.HIGH)
                .status(Alert.Status.NEW)
                .assignedTo("John Doe")
                .createdAt(Instant.now())
                .description("Test alert")
                .fraudType(fraudType)
                .build();

        assertEquals(fraudType, alert.fraudType());
        assertNotNull(fraudType.getDisplayName());
    }

    @Test
    void shouldThrowExceptionWhenRequiredFieldsAreMissing() {
        assertThrows(NullPointerException.class, () -> 
            Alert.builder()
                .alertId("ALERT-001")
                .transactionId("TXN-001")
                .severity(Alert.Severity.HIGH)
                .status(Alert.Status.NEW)
                .assignedTo("John Doe")
                .createdAt(Instant.now())
                .description("Test alert")
                .build()
        );
    }
} 