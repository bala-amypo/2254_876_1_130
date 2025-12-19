package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class WarrantyClaimServiceImpl {

    @Autowired
    private DeviceOwnershipRepository deviceRepo;

    public boolean isWarrantyValid(String serialNumber) {
        DeviceOwnershipRecord device = deviceRepo.findBySerialNumber(serialNumber);
        if (device == null) return false;
        LocalDate expiration = device.getWarrantyExpiration();
        return expiration != null && expiration.isAfter(LocalDate.now());
    }
}
