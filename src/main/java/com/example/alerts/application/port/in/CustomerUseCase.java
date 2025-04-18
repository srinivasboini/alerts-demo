package com.example.alerts.application.port.in;

import com.example.alerts.domain.model.Customer;
import java.util.List;

public interface CustomerUseCase {
    List<Customer> getAllCustomers();
    Customer getCustomerById(String customerId);
} 