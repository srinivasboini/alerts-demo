package com.example.alerts.application.service;

import com.example.alerts.application.port.in.CustomerUseCase;
import com.example.alerts.domain.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CustomerService implements CustomerUseCase {
    private final List<Customer> customers = Arrays.asList(
        Customer.builder()
            .customerId("CUST-2024-001")
            .name("John Smith")
            .riskProfile("Medium")
            .kycStatus("Verified")
            .accounts(Arrays.asList("ACC-123456", "ACC-789012"))
            .createdAt(Instant.parse("2024-01-15T10:30:00Z").atOffset(ZoneOffset.UTC).toLocalDateTime())
            .lastUpdated(Instant.parse("2024-03-20T14:45:00Z").atOffset(ZoneOffset.UTC).toLocalDateTime())
            .build(),
        Customer.builder()
            .customerId("CUST-2024-002")
            .name("Emily Johnson")
            .riskProfile("Low")
            .kycStatus("Verified")
            .accounts(Arrays.asList("ACC-345678"))
            .createdAt(Instant.parse("2024-02-01T09:15:00Z").atOffset(ZoneOffset.UTC).toLocalDateTime())
            .lastUpdated(Instant.parse("2024-03-19T11:20:00Z").atOffset(ZoneOffset.UTC).toLocalDateTime())
            .build(),
        Customer.builder()
            .customerId("CUST-2024-003")
            .name("Michael Brown")
            .riskProfile("High")
            .kycStatus("Pending")
            .accounts(Arrays.asList("ACC-901234", "ACC-567890"))
            .createdAt(Instant.parse("2024-02-15T14:30:00Z").atOffset(ZoneOffset.UTC).toLocalDateTime())
            .lastUpdated(Instant.parse("2024-03-18T16:45:00Z").atOffset(ZoneOffset.UTC).toLocalDateTime())
            .build(),
        Customer.builder()
            .customerId("CUST-2024-004")
            .name("Sarah Wilson")
            .riskProfile("Medium")
            .kycStatus("Failed")
            .accounts(Arrays.asList("ACC-234567"))
            .createdAt(Instant.parse("2024-03-01T11:45:00Z").atOffset(ZoneOffset.UTC).toLocalDateTime())
            .lastUpdated(Instant.parse("2024-03-17T10:30:00Z").atOffset(ZoneOffset.UTC).toLocalDateTime())
            .build(),
        Customer.builder()
            .customerId("CUST-2024-005")
            .name("David Miller")
            .riskProfile("Low")
            .kycStatus("Verified")
            .accounts(Arrays.asList("ACC-890123", "ACC-456789"))
            .createdAt(Instant.parse("2024-03-05T13:20:00Z").atOffset(ZoneOffset.UTC).toLocalDateTime())
            .lastUpdated(Instant.parse("2024-03-16T15:15:00Z").atOffset(ZoneOffset.UTC).toLocalDateTime())
            .build(),
        Customer.builder()
            .customerId("CUST-2024-006")
            .name("Lisa Anderson")
            .riskProfile("High")
            .kycStatus("Verified")
            .accounts(Arrays.asList("ACC-678901"))
            .createdAt(Instant.parse("2024-03-10T10:00:00Z").atOffset(ZoneOffset.UTC).toLocalDateTime())
            .lastUpdated(Instant.parse("2024-03-15T09:45:00Z").atOffset(ZoneOffset.UTC).toLocalDateTime())
            .build(),
        Customer.builder()
            .customerId("CUST-2024-007")
            .name("Robert Davis")
            .riskProfile("Medium")
            .kycStatus("Pending")
            .accounts(Arrays.asList("ACC-123890", "ACC-456123"))
            .createdAt(Instant.parse("2024-03-12T15:30:00Z").atOffset(ZoneOffset.UTC).toLocalDateTime())
            .lastUpdated(Instant.parse("2024-03-14T14:20:00Z").atOffset(ZoneOffset.UTC).toLocalDateTime())
            .build(),
        Customer.builder()
            .customerId("CUST-2024-008")
            .name("Jennifer Taylor")
            .riskProfile("Low")
            .kycStatus("Verified")
            .accounts(Arrays.asList("ACC-789345"))
            .createdAt(Instant.parse("2024-03-15T09:45:00Z").atOffset(ZoneOffset.UTC).toLocalDateTime())
            .lastUpdated(Instant.parse("2024-03-16T11:30:00Z").atOffset(ZoneOffset.UTC).toLocalDateTime())
            .build()
    );

    @Override
    public List<Customer> getAllCustomers() {
        log.info("Fetching all customers");
        return customers;
    }

    @Override
    public Customer getCustomerById(String customerId) {
        log.info("Fetching customer with ID: {}", customerId);
        Optional<Customer> customer = customers.stream()
                .filter(c -> c.customerId().equals(customerId))
                .findFirst();
        
        if (customer.isPresent()) {
            log.info("Customer found with ID: {}", customerId);
            return customer.get();
        } else {
            log.warn("Customer not found with ID: {}", customerId);
            throw new RuntimeException("Customer not found with ID: " + customerId);
        }
    }
} 