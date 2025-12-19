package com.example.demo.service.impl;

import com.example.demo.entity.StolenDeviceReport;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceReportRepository stolenRepo;
    private final DeviceOwnershipRecordRepository deviceRepo;

    public StolenDeviceServiceImpl(StolenDeviceReportRepository stolenRepo,
                                   DeviceOwnershipRecordRepository deviceRepo) {
        this.stolenRepo = stolenRepo;
        this.deviceRepo = deviceRepo;
    }

    @Override
    public StolenDeviceReport reportStolenDevice(StolenDeviceReport stolenDevice) {
        if (!deviceRepo.existsById(stolenDevice.getDeviceId())) {
            throw new IllegalArgumentException("Device does not exist");
        }
        if (stolenRepo.existsBySerialNumber(stolenDevice.getSerialNumber())) {
            throw new IllegalArgumentException("Device already reported stolen");
        }
        return stolenRepo.save(stolenDevice);
    }

    @Override
    public List<StolenDeviceReport> getAllStolenDevices() {
        return stolenRepo.findAll();
    }

    @Override
    public boolean isDeviceStolen(String serialNumber) {
        return stolenRepo.existsBySerialNumber(serialNumber);
    }
}
