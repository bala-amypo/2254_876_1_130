package com.example.demo.service;

import com.example.demo.model.StolenDeviceReport;
import java.util.List;
import java.util.Optional;

public interface StolenDeviceService {
    List<StolenDeviceReport> getAllReports();
    StolenDeviceReport reportStolenDevice(StolenDeviceReport report);
    Optional<StolenDeviceReport> findBySerialNumber(String serialNumber);
    Optional<StolenDeviceReport> getReportById(Long id);
    List<StolenDeviceReport> getReportsBySerial(String serialNumber);
}
