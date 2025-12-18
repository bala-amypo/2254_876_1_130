package com.example.demo.repository;

import com.example.demo.model.FraudAlertRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FraudAlertRecordRepository extends JpaRepository<FraudAlertRecord, Long> {

    // Find all alerts for a specific claim ID
    List<FraudAlertRecord> findByClaimId(Long claimId);

    // Find all unresolved alerts
    List<FraudAlertRecord> findByResolvedFalse();

    // Custom query: search alerts by keyword in alertReason
    @Query("SELECT f FROM FraudAlertRecord f WHERE f.alertReason LIKE %?1%")
    List<FraudAlertRecord> findByAlertReasonContaining(String keyword);

    // Optional: find alert by exact alertReason
    FraudAlertRecord findByAlertReason(String alertReason);
}
