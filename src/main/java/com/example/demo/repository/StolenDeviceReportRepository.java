package com.example.demo.repository;

import com.example.demo.entity.StolenDeviceReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StolenDeviceRepository extends JpaRepository<StolenDeviceReport, Long> {
    boolean existsBySerialNumber(String serialNumber);
}
