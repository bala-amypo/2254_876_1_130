package com.example.demo.repository;

import com.example.demo.model.WarrantyClaimRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface WarrantyClaimRecordRepository extends JpaRepository<WarrantyClaimRecord, Long> {
    Optional<WarrantyClaimRecord> findBySerialNumber(String serialNumber);  // needed in service
}
