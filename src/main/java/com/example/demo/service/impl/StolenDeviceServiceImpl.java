package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceReportRepository stolenRepository;
    private final DeviceOwnershipRecordRepository deviceRepository;

    public StolenDeviceServiceImpl(StolenDeviceReportRepository stolenRepository,
                                   DeviceOwnershipRecordRepository deviceRepository) {
        this.stolenRepository = stolenRepository;
        this.deviceRepository = deviceRepository;
    }

    @Override
    public StolenDeviceReport reportStolen(StolenDeviceReport report) {
        // Validate device exists
        DeviceOwnershipRecord device = deviceRepository.findBySerialNumber(report.getSerialNumber())
                .orElseThrow(() -> new NoSuchElementException("Device not found"));

        report.setReportDate(LocalDateTime.now());
        return stolenRepository.save(report);
    }

    @Override
    public List<StolenDeviceReport> getReportsBySerial(String serialNumber) {
        return stolenRepository.findBySerialNumber(serialNumber);
    }

    @Override
    public Optional<StolenDeviceReport> getReportById(Long id) {
        return stolenRepository.findById(id);
    }

    @Override
    public List<StolenDeviceReport> getAllReports() {
        return stolenRepository.findAll();
    }
}
