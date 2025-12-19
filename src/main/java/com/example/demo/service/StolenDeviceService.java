package com.example.demo.service;

import com.example.demo.entity.StolenDeviceReport;
import java.util.List;

public interface StolenDeviceService {
    StolenDeviceReport reportStolenDevice(StolenDeviceReport stolenDevice);
    List<StolenDeviceReport> getAllStolenDevices();
    boolean isDeviceStolen(String serialNumber);
}
