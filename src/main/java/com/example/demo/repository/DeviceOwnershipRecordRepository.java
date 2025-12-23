package com.example.demo.repository;

import com.example.demo.model.DeviceOwnershipRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DeviceOwnershipRecordRepository extends JpaRepository<DeviceOwnershipRecord, Long> {
    boolean existsBySerialNumber(String serialNumber);  // for your service check
    Optional<DeviceOwnershipRecord> findBySerialNumber(String serialNumber);
}
