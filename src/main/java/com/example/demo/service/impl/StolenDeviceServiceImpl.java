package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceService;
import org.springframework.stereotype.Service;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final DeviceOwnershipRecordRepository deviceRepo;
    private final StolenDeviceReportRepository reportRepo;

    public StolenDeviceServiceImpl(DeviceOwnershipRecordRepository deviceRepo,
                                   StolenDeviceReportRepository reportRepo) {
        this.deviceRepo = deviceRepo;
        this.reportRepo = reportRepo;
    }

    @Override
    public StolenDeviceReport reportStolenDevice(String serialNumber, String reportedBy, String details) {

        DeviceOwnershipRecord device = deviceRepo.findAll()
                .stream()
                .filter(d -> d.getSerialNumber().equals(serialNumber))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Device not found"));

        StolenDeviceReport report = new StolenDeviceReport(serialNumber, reportedBy, details, device);

        return reportRepo.save(report);
    }
}
