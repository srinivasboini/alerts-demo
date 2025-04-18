package com.example.alerts.application.port.in;

import com.example.alerts.domain.model.Alert;
import java.util.List;

public interface AlertUseCase {
    List<Alert> getAllAlerts();
} 