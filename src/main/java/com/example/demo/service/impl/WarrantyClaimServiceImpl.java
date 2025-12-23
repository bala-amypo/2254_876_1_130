package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.WarrantyClaimRepository;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRepository warrantyClaimRepository;

    public WarrantyClaimServiceImpl(WarrantyClaimRepository warrantyClaimRepository) {
        this.warrantyClaimRepository = warrantyClaimRepository;
    }

    @Override
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim, DeviceOwnershipRecord device) {
        // Use LocalDateTime instead of LocalDate
        claim.setSubmittedAt(LocalDateTime.now());
        claim.setCreatedAt(LocalDateTime.now());

        // Example: get device serial number or warranty expiration
        String serial = device.getSerialNumber();
        LocalDateTime warrantyExpiry = device.getWarrantyExpiration();

        // Add other logic as needed

        return warrantyClaimRepository.save(claim);
    }

    @Override
    public List<WarrantyClaimRecord> getAllClaims() {
        return warrantyClaimRepository.findAll();
    }
}
