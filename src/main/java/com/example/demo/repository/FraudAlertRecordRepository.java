package com.example.demo.repository;

import com.example.demo.model.FraudAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudAlertRepository extends JpaRepository<FraudAlert, Long> {
}package com.example.demo.repository;

import com.example.demo.model.FraudAlertRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudAlertRecordRepository
        extends JpaRepository<FraudAlertRecord, Long> {
}
