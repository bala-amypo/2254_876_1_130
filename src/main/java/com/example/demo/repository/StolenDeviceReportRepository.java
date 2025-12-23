package com.example.demo.repository;

import com.example.demo.model.StolenDeviceReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StolenDeviceRepository extends JpaRepository<StolenDeviceReport, Long> {
    // Add custom query methods if needed
}
