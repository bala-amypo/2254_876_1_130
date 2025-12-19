package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import com.example.demo.service.WarrantyClaimService;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final DeviceOwnershipRecordRepository deviceRepository;
    private final WarrantyClaimRecordRepository claimRepository;

    public WarrantyClaimServiceImpl(
            DeviceOwnershipRecordRepository deviceRepository,
            WarrantyClaimRecordRepository claimRepository) {

        this.deviceRepository = deviceRepository;
        this.claimRepository = claimRepository;
    }

    @Override
    public boolean isWarrantyValid(String serialNumber) {

        DeviceOwnershipRecord device =
                deviceRepository.findBySerialNumber(serialNumber)
                        .orElse(null);

        if (device == null) {
            return false;
        }

        return device.getWarrantyExpiration()
                .isAfter(LocalDate.now());
    }

    @Override
    public List<WarrantyClaimRecord> getAllClaims() {
        return claimRepository.findAll();
    }
}
