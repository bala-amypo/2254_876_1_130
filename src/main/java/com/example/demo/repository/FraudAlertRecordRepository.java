package com.example.demo.repository;

import com.example.demo.model.FraudAlertRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FraudAlertRecordRepository extends JpaRepository<FraudAlertRecord, Long> {
    Optional<FraudAlertRecord> findBySerialNumber(String serialNumber);
    List<FraudAlertRecord> findByClaimId(Long claimId);
}
