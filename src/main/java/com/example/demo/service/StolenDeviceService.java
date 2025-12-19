package com.example.demo.service;

import com.example.demo.entity.StolenDeviceReport;

import java.util.List;

public interface StolenDeviceService {

    StolenDeviceReport reportStolen(StolenDeviceReport report);

    List<StolenDeviceReport> getAllReports();

    StolenDeviceReport getReportById(Long id);

    List<StolenDeviceReport> getReportsBySerial(String serialNumber);
}
