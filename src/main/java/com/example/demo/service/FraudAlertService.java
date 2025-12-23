package com.example.demo.service;

import com.example.demo.model.FraudAlert;

import java.util.List;
import java.util.Optional;

public interface FraudAlertService {

    FraudAlert createAlert(FraudAlert alert);

    FraudAlert resolveAlert(Long id);

    Optional<FraudAlert> getAlertById(Long id);

    List<FraudAlert> getAllAlerts();
}
