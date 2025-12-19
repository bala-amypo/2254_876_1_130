package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final DeviceOwnershipRecordRepository deviceOwnershipRecordRepository;
    private final StolenDeviceReportRepository stolenDeviceReportRepository;

    public StolenDeviceServiceImpl(
            DeviceOwnershipRecordRepository deviceOwnershipRecordRepository,
            StolenDeviceReportRepository stolenDeviceReportRepository) {

        this.deviceOwnershipRecordRepository = deviceOwnershipRecordRepository;
        this.stolenDeviceReportRepository = stolenDeviceReportRepository;
    }

    @Override
    public StolenDeviceReport reportStolenDevice(
            String serialNumber,
            String reportedBy,
            String details) {

        DeviceOwnershipRecord device = deviceOwnershipRecordRepository
                .findAll()
                .stream()
                .filter(d -> d.getSerialNumber().equals(serialNumber))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Device not found with serial number: " + serialNumber));

        StolenDeviceReport report = new StolenDeviceReport(
                serialNumber,
                reportedBy,
                device
        );

        report.setDetails(details);

        return stolenDeviceReportRepository.save(report);
    }

    @Override
    public List<StolenDeviceReport> getAllReports() {
        return stolenDeviceReportRepository.findAll();
    }
}
