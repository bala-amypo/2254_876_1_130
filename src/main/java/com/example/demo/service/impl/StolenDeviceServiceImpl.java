package com.example.demo.service.impl;

import com.example.demo.repository.DeviceOwnershipRepository;
import com.example.demo.repository.WarrantyClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StolenDeviceServiceImpl {

    private final DeviceOwnershipRepository deviceOwnershipRepository;
    private final WarrantyClaimRepository warrantyClaimRepository;

    @Autowired
    public StolenDeviceServiceImpl(DeviceOwnershipRepository deviceOwnershipRepository,
                                   WarrantyClaimRepository warrantyClaimRepository) {
        this.deviceOwnershipRepository = deviceOwnershipRepository;
        this.warrantyClaimRepository = warrantyClaimRepository;
    }

    // Example method
    public boolean isDeviceStolen(String serialNumber) {
        return deviceOwnershipRepository.findAll().stream()
                .noneMatch(d -> d.getDeviceSerialNumber().equals(serialNumber));
    }
}
