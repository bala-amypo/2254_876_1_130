package com.example.demo.repository;

import com.example.demo.model.FraudAlertRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FraudAlertRepository extends JpaRepository<FraudAlertRecord, Long> {

    // Get all unresolved alerts
    @Query("SELECT f FROM FraudAlertRecord f WHERE f.resolved = false")
    List<FraudAlertRecord> findUnresolvedAlerts();

    // Get alerts by claimId
    List<FraudAlertRecord> findByClaimId(Long claimId);
}
