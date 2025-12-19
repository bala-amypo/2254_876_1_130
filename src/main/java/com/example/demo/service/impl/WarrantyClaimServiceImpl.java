package com.example.demo.service.impl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.WarrantyClaimService;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final DeviceOwnershipRecordRepository repository;

    public WarrantyClaimServiceImpl(
            DeviceOwnershipRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isWarrantyValid(String serialNumber) {

        DeviceOwnershipRecord device =
                repository.findBySerialNumber(serialNumber)
                          .orElse(null);

        if (device == null) {
            return false;
        }

        return device.getWarrantyExpiration()
                     .isAfter(LocalDate.now());
    }
}
