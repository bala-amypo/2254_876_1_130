package com.example.demo.service.impl;

import com.example.demo.entity.DeviceOwnershipRecord;
import com.example.demo.entity.StolenDeviceReport;
import com.example.demo.repository.DeviceOwnershipRepository;
import com.example.demo.repository.StolenDeviceRepository;
import com.example.demo.service.StolenDeviceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceRepository stolenRepo;
    private final DeviceOwnershipRepository deviceRepo;

    public StolenDeviceServiceImpl(StolenDeviceRepository stolenRepo, DeviceOwnershipRepository deviceRepo) {
        this.stolenRepo = stolenRepo;
        this.deviceRepo = deviceRepo;
    }

    @Override
    public StolenDeviceReport reportStolen(StolenDeviceReport report) {
        // Find device by serial number
        DeviceOwnershipRecord device = deviceRepo.findBySerialNumber(report.getSerialNumber())
                .orElseThrow(() -> new NoSuchElementException("Device not found"));

        // Link the report to the device
        report.setDeviceOwnershipRecord(device);

        // Save report
        return stolenRepo.save(report);
    }

    @Override
    public List<StolenDeviceReport> getAllReports() {
        return stolenRepo.findAll();
    }

    @Override
    public Optional<StolenDeviceReport> getReportById(Long id) {
        return stolenRepo.findById(id);
    }

    @Override
    public List<StolenDeviceReport> getReportsBySerial(String serialNumber) {
        return stolenRepo.findBySerialNumber(serialNumber);
    }
}
