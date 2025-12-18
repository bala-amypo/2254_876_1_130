package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceReportRepository stolenRepository;
    private final DeviceOwnershipRecordRepository deviceRepository;

    @Override
    public StolenDeviceReport reportStolenDevice(String serialNumber) {
        Optional<DeviceOwnershipRecord> deviceOpt = deviceRepository.findBySerialNumber(serialNumber);
        if (deviceOpt.isEmpty()) {
            throw new IllegalArgumentException("Device not found for serial number: " + serialNumber);
        }

        StolenDeviceReport report = new StolenDeviceReport();
        report.setDevice(deviceOpt.get()); // correctly set the device
        report.setReported(true); // assuming you have a reported flag
        return stolenRepository.save(report);
    }

    @Override
    public Optional<StolenDeviceReport> getBySerial(String serialNumber) {
        // Repository should return Optional
        return stolenRepository.findBySerialNumber(serialNumber);
    }
}
