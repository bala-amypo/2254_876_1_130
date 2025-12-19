package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.FraudAlertRecord;

public interface FraudAlertService {

    FraudAlertRecord createAlert(FraudAlertRecord alert);

    FraudAlertRecord resolveAlert(Long id);

    List<FraudAlertRecord> getAlertsBySerial(String serialNumber);

    List<FraudAlertRecord> getAlertsByClaim(Long claimId);

    List<FraudAlertRecord> getAllAlerts();
}
