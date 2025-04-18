package com.example.alerts.infrastructure.adapter.in.web;

import com.example.alerts.application.port.in.CustomerUseCase;
import com.example.alerts.domain.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerUseCase customerUseCase;

    public CustomerController(CustomerUseCase customerUseCase) {
        this.customerUseCase = customerUseCase;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        logger.info("Received request to get all customers");
        try {
            List<Customer> customers = customerUseCase.getAllCustomers();
            logger.info("Successfully retrieved {} customers", customers.size());
            return ResponseEntity.ok(customers);
        } catch (Exception e) {
            logger.error("Error while fetching all customers", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String customerId) {
        logger.info("Received request to get customer with ID: {}", customerId);
        try {
            Customer customer = customerUseCase.getCustomerById(customerId);
            logger.info("Successfully retrieved customer with ID: {}", customerId);
            return ResponseEntity.ok(customer);
        } catch (RuntimeException e) {
            logger.warn("Customer not found with ID: {}", customerId);
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            logger.error("Error while fetching customer with ID: {}", customerId, e);
            return ResponseEntity.internalServerError().build();
        }
    }
} 