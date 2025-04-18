package com.example.alerts.application.port.out;

import com.example.alerts.domain.model.Alert;
import java.util.List;

public interface AlertPort {
    List<Alert> findAllAlerts();
} 