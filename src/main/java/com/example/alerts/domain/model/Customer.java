package com.example.alerts.domain.model;

import lombok.Builder;
import java.time.LocalDateTime;
import java.util.List;

@Builder
public record Customer(
    String customerId,
    String name,
    String riskProfile,
    String kycStatus,
    List<String> accounts,
    LocalDateTime createdAt,
    LocalDateTime lastUpdated
) {} 