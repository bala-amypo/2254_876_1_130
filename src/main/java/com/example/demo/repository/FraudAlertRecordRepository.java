package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.FraudAlertRecord;

public interface FraudAlertRecordRepository
        extends JpaRepository<FraudAlertRecord, Long> {

    List<FraudAlertRecord> findByClaimId(Long claimId);

    List<FraudAlertRecord> findBySerialNumber(String serialNumber);

    List<FraudAlertRecord> findByResolved(Boolean resolved);
}
