package com.example.alerts.infrastructure.adapter.in.web;

import com.example.alerts.application.port.in.AlertUseCase;
import com.example.alerts.domain.model.Alert;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alerts")
@RequiredArgsConstructor
@Slf4j
public class AlertController {
    private final AlertUseCase alertUseCase;

    @GetMapping
    public ResponseEntity<List<Alert>> getAllAlerts() {
        log.info("Received request to get all alerts");
        try {
            List<Alert> alerts = alertUseCase.getAllAlerts();
            log.info("Successfully retrieved {} alerts", alerts.size());
            return ResponseEntity.ok(alerts);
        } catch (Exception e) {
            log.error("Error while fetching all alerts", e);
            return ResponseEntity.internalServerError().build();
        }
    }
} 