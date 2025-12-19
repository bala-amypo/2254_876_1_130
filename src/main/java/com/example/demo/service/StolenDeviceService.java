package com.example.demo.service;

import com.example.demo.model.StolenDeviceReport;

public interface StolenDeviceService {

    StolenDeviceReport reportStolenDevice(
            String serialNumber,
            String reportedBy,
            String details
    );
}
