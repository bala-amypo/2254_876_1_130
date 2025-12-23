package com.example.demo.repository;

import com.example.demo.entity.FraudAlertRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudAlertRepository
        extends JpaRepository<FraudAlertRecord, Long> {
}
