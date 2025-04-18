package com.example.alerts.infrastructure.adapter.out.persistence;

import com.example.alerts.domain.model.Alert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlertPersistenceAdapterTest {

    private AlertPersistenceAdapter alertPersistenceAdapter;

    @BeforeEach
    void setUp() {
        alertPersistenceAdapter = new AlertPersistenceAdapter();
    }

    @Test
    void shouldReturnAllAlerts() {
        List<Alert> alerts = alertPersistenceAdapter.findAllAlerts();
        
        assertNotNull(alerts);
        assertFalse(alerts.isEmpty());
        assertEquals(8, alerts.size());
    }

    @Test
    void shouldReturnAlertsWithCorrectData() {
        List<Alert> alerts = alertPersistenceAdapter.findAllAlerts();
        
        Alert firstAlert = alerts.get(0);
        assertEquals("ALERT-2024-001", firstAlert.alertId());
        assertEquals("TXN-123456", firstAlert.transactionId());
        assertEquals(Alert.Severity.HIGH, firstAlert.severity());
        assertEquals(Alert.Status.NEW, firstAlert.status());
        assertEquals("John Doe", firstAlert.assignedTo());
        assertEquals("Multiple failed login attempts from different locations within a short time period", 
            firstAlert.description());
        assertEquals(Alert.FraudType.ACCOUNT_TAKEOVER, firstAlert.fraudType());
    }

    @Test
    void shouldReturnAlertsWithDifferentSeverityLevels() {
        List<Alert> alerts = alertPersistenceAdapter.findAllAlerts();
        
        long highSeverityCount = alerts.stream()
                .filter(a -> Alert.Severity.HIGH.equals(a.severity()))
                .count();
        long mediumSeverityCount = alerts.stream()
                .filter(a -> Alert.Severity.MEDIUM.equals(a.severity()))
                .count();
        long lowSeverityCount = alerts.stream()
                .filter(a -> Alert.Severity.LOW.equals(a.severity()))
                .count();
        
        assertTrue(highSeverityCount > 0);
        assertTrue(mediumSeverityCount > 0);
        assertTrue(lowSeverityCount > 0);
    }

    @Test
    void shouldReturnAlertsWithDifferentStatuses() {
        List<Alert> alerts = alertPersistenceAdapter.findAllAlerts();
        
        long newCount = alerts.stream()
                .filter(a -> Alert.Status.NEW.equals(a.status()))
                .count();
        long assignedCount = alerts.stream()
                .filter(a -> Alert.Status.ASSIGNED.equals(a.status()))
                .count();
        long inProgressCount = alerts.stream()
                .filter(a -> Alert.Status.IN_PROGRESS.equals(a.status()))
                .count();
        long closedCount = alerts.stream()
                .filter(a -> Alert.Status.CLOSED.equals(a.status()))
                .count();
        
        assertTrue(newCount > 0);
        assertTrue(assignedCount > 0);
        assertTrue(inProgressCount > 0);
        assertTrue(closedCount > 0);
    }

    @Test
    void shouldReturnAlertsWithDifferentFraudTypes() {
        List<Alert> alerts = alertPersistenceAdapter.findAllAlerts();
        
        long accountTakeoverCount = alerts.stream()
                .filter(a -> Alert.FraudType.ACCOUNT_TAKEOVER.equals(a.fraudType()))
                .count();
        long transactionFraudCount = alerts.stream()
                .filter(a -> Alert.FraudType.TRANSACTION_FRAUD.equals(a.fraudType()))
                .count();
        long identityTheftCount = alerts.stream()
                .filter(a -> Alert.FraudType.IDENTITY_THEFT.equals(a.fraudType()))
                .count();
        
        assertTrue(accountTakeoverCount > 0);
        assertTrue(transactionFraudCount > 0);
        assertTrue(identityTheftCount > 0);
    }

    @ParameterizedTest
    @EnumSource(Alert.FraudType.class)
    void shouldHaveDisplayNameForAllFraudTypes(Alert.FraudType fraudType) {
        assertNotNull(fraudType.getDisplayName());
        assertFalse(fraudType.getDisplayName().isEmpty());
    }
} 