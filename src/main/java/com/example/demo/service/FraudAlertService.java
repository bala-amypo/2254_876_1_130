package com.example.demo.service;

import com.example.demo.model.FraudAlertRecord;
import java.util.List;

public interface FraudAlertService {
    FraudAlertRecord createAlert(FraudAlertRecord alert);
    List<FraudAlertRecord> getAllAlerts();
    FraudAlertRecord getAlertById(Long id);
    void resolveAlert(Long id);
}
