package com.example.demo.service;

import com.example.demo.model.StolenDeviceReport;
import java.util.List;

public interface StolenDeviceService {

    StolenDeviceReport reportStolenDevice(
            String serialNumber,
            String reportedBy,
            String details
    );

    List<StolenDeviceReport> getAllReports();
}
