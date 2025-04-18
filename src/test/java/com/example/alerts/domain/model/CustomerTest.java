package com.example.alerts.domain.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void shouldCreateCustomerWithBuilder() {
        List<String> accounts = Arrays.asList("ACC-001", "ACC-002");
        LocalDateTime now = LocalDateTime.now();

        Customer customer = Customer.builder()
                .customerId("CUST-001")
                .name("John Doe")
                .riskProfile("Medium")
                .kycStatus("Verified")
                .accounts(accounts)
                .createdAt(now)
                .lastUpdated(now)
                .build();

        assertNotNull(customer);
        assertEquals("CUST-001", customer.customerId());
        assertEquals("John Doe", customer.name());
        assertEquals("Medium", customer.riskProfile());
        assertEquals("Verified", customer.kycStatus());
        assertEquals(accounts, customer.accounts());
        assertEquals(now, customer.createdAt());
        assertEquals(now, customer.lastUpdated());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Low", "Medium", "High"})
    void shouldSupportDifferentRiskProfiles(String riskProfile) {
        Customer customer = Customer.builder()
                .customerId("CUST-001")
                .name("John Doe")
                .riskProfile(riskProfile)
                .kycStatus("Verified")
                .accounts(Arrays.asList("ACC-001"))
                .createdAt(LocalDateTime.now())
                .lastUpdated(LocalDateTime.now())
                .build();

        assertEquals(riskProfile, customer.riskProfile());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Verified", "Pending", "Failed"})
    void shouldSupportDifferentKycStatuses(String kycStatus) {
        Customer customer = Customer.builder()
                .customerId("CUST-001")
                .name("John Doe")
                .riskProfile("Medium")
                .kycStatus(kycStatus)
                .accounts(Arrays.asList("ACC-001"))
                .createdAt(LocalDateTime.now())
                .lastUpdated(LocalDateTime.now())
                .build();

        assertEquals(kycStatus, customer.kycStatus());
    }

    @Test
    void shouldSupportMultipleAccounts() {
        List<String> accounts = Arrays.asList("ACC-001", "ACC-002", "ACC-003");
        
        Customer customer = Customer.builder()
                .customerId("CUST-001")
                .name("John Doe")
                .riskProfile("Medium")
                .kycStatus("Verified")
                .accounts(accounts)
                .createdAt(LocalDateTime.now())
                .lastUpdated(LocalDateTime.now())
                .build();

        assertEquals(3, customer.accounts().size());
        assertTrue(customer.accounts().containsAll(accounts));
    }

    @Test
    void shouldThrowExceptionWhenRequiredFieldsAreMissing() {
        assertThrows(NullPointerException.class, () -> 
            Customer.builder()
                .customerId("CUST-001")
                .name("John Doe")
                .riskProfile("Medium")
                .kycStatus("Verified")
                .accounts(Arrays.asList("ACC-001"))
                .createdAt(LocalDateTime.now())
                .build()
        );
    }
} 