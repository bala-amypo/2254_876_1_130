package com.example.demo.repository;

import com.example.demo.model.FraudAlertRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudAlertRecordRepository extends JpaRepository<FraudAlertRecord, Long> {
}
