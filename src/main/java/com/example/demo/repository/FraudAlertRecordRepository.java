package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.FraudAlertRecord;

@Repository
public interface FraudAlertRecordRepository
        extends JpaRepository<FraudAlertRecord, Long> {

    List<FraudAlertRecord> findByClaimId(Long claimId);

    List<FraudAlertRecord> findBySerialNumber(String serialNumber);

    List<FraudAlertRecord> findByResolved(Boolean resolved);
}
