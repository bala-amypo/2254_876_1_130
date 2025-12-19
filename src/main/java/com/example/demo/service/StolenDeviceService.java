package com.example.demo.service;

import com.example.demo.entity.StolenDeviceReport;

public interface StolenDeviceService {

    StolenDeviceReport reportStolenDevice(String serialNumber, String reason);
}
