package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.WarrantyClaimRepository;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    @Autowired
    private WarrantyClaimRepository claimRepository;

    @Override
    public WarrantyClaimRecord submitClaim(String description, DeviceOwnershipRecord device) {
        WarrantyClaimRecord claim = new WarrantyClaimRecord();
        claim.setDescription(description);
        claim.setDevice(device);
        claim.setSubmittedAt(LocalDateTime.now());
        claim.setCreatedAt(LocalDateTime.now());
        return claimRepository.save(claim);
    }

    @Override
    public List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber) {
        return claimRepository.findByDeviceSerialNumber(serialNumber);
    }
}
