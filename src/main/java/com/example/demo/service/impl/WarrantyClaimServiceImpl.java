package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.WarrantyClaimRepository;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<WarrantyClaimRecord> getAllClaims() {
        return claimRepository.findAll();
    }

    @Override
    public WarrantyClaimRecord getClaimById(Long id) {
        Optional<WarrantyClaimRecord> claim = claimRepository.findById(id);
        return claim.orElse(null);
    }

    @Override
    public WarrantyClaimRecord updateClaimStatus(Long id, String status) {
        WarrantyClaimRecord claim = getClaimById(id);
        if (claim != null) {
            claim.setStatus(status);
            return claimRepository.save(claim);
        }
        return null;
    }
}
