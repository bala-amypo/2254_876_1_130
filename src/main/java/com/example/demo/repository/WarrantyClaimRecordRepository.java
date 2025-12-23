package com.example.demo.repository;

import com.example.demo.model.WarrantyClaimRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarrantyClaimRepository extends JpaRepository<WarrantyClaimRecord, Long> {
    // This method matches the service interface requirement
    List<WarrantyClaimRecord> findByDeviceSerialNumber(String serialNumber);
}
