package com.example.alerts.application.service;

import com.example.alerts.application.port.in.AlertUseCase;
import com.example.alerts.application.port.out.AlertPort;
import com.example.alerts.domain.model.Alert;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AlertService implements AlertUseCase {
    private final AlertPort alertPort;

    @Override
    public List<Alert> getAllAlerts() {
        log.info("Fetching all alerts");
        List<Alert> alerts = alertPort.findAllAlerts();
        log.info("Successfully retrieved {} alerts", alerts.size());
        return alerts;
    }
} 