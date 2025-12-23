package com.example.demo.service;

import com.example.demo.model.StolenDeviceReport;
import java.util.List;

public interface StolenDeviceService {
    StolenDeviceReport addReport(StolenDeviceReport report);
    List<StolenDeviceReport> getAllReports();
    StolenDeviceReport getReportById(Long id);
    void deleteReport(Long id);
}
