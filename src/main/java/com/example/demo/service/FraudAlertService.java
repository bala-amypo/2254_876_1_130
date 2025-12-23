package com.example.demo.service;

import com.example.demo.model.FraudAlert;
import java.util.List;

public interface FraudAlertService {
    FraudAlert createAlert(FraudAlert alert);
    List<FraudAlert> getAllAlerts();
    FraudAlert getAlertById(Long id);
    void deleteAlert(Long id);
}
