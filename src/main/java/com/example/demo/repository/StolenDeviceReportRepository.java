package com.example.demo.repository;

import com.example.demo.model.StolenDeviceReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StolenDeviceReportRepository extends JpaRepository<StolenDeviceReport, Long> {
    // Change return type to List instead of Optional
    List<StolenDeviceReport> findBySerialNumber(String serialNumber);
}
