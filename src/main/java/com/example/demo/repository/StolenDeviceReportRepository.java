package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.DeviceOwnershipRecord;

public interface StolenDeviceReportRepository extends JpaRepository<DeviceOwnershipRecord, Long> {
    boolean existsBySerialNumber(String serialNumber);
}
