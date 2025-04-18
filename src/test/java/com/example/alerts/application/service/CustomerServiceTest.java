package com.example.alerts.application.service;

import com.example.alerts.domain.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Test
    void shouldReturnAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        
        assertNotNull(customers);
        assertFalse(customers.isEmpty());
        assertEquals(8, customers.size());
    }

    @ParameterizedTest
    @ValueSource(strings = {"CUST-2024-001", "CUST-2024-002", "CUST-2024-003"})
    void shouldReturnCustomerById(String customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        
        assertNotNull(customer);
        assertEquals(customerId, customer.customerId());
    }

    @Test
    void shouldThrowExceptionWhenCustomerNotFound() {
        String nonExistentId = "NON-EXISTENT";
        
        Exception exception = assertThrows(RuntimeException.class, () -> 
            customerService.getCustomerById(nonExistentId)
        );
        
        assertEquals("Customer not found with ID: " + nonExistentId, exception.getMessage());
    }

    @Test
    void shouldReturnCustomerWithCorrectData() {
        Customer customer = customerService.getCustomerById("CUST-2024-001");
        
        assertEquals("John Smith", customer.name());
        assertEquals("Medium", customer.riskProfile());
        assertEquals("Verified", customer.kycStatus());
        assertEquals(2, customer.accounts().size());
        assertTrue(customer.accounts().containsAll(Arrays.asList("ACC-123456", "ACC-789012")));
    }

    @Test
    void shouldReturnCustomersWithDifferentRiskProfiles() {
        List<Customer> customers = customerService.getAllCustomers();
        
        long highRiskCount = customers.stream()
                .filter(c -> "High".equals(c.riskProfile()))
                .count();
        long mediumRiskCount = customers.stream()
                .filter(c -> "Medium".equals(c.riskProfile()))
                .count();
        long lowRiskCount = customers.stream()
                .filter(c -> "Low".equals(c.riskProfile()))
                .count();
        
        assertTrue(highRiskCount > 0);
        assertTrue(mediumRiskCount > 0);
        assertTrue(lowRiskCount > 0);
    }

    @Test
    void shouldReturnCustomersWithDifferentKycStatuses() {
        List<Customer> customers = customerService.getAllCustomers();
        
        long verifiedCount = customers.stream()
                .filter(c -> "Verified".equals(c.kycStatus()))
                .count();
        long pendingCount = customers.stream()
                .filter(c -> "Pending".equals(c.kycStatus()))
                .count();
        long failedCount = customers.stream()
                .filter(c -> "Failed".equals(c.kycStatus()))
                .count();
        
        assertTrue(verifiedCount > 0);
        assertTrue(pendingCount > 0);
        assertTrue(failedCount > 0);
    }
} 