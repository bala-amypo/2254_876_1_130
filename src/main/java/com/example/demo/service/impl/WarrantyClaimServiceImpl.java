package com.example.demo.service.impl;

import com.example.demo.entity.WarrantyClaimRecord;
import com.example.demo.model.DeviceOwnership;
import com.example.demo.repository.WarrantyClaimRepository;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRepository repository;

    public WarrantyClaimServiceImpl(WarrantyClaimRepository repository) {
        this.repository = repository;
    }

    @Override
    public WarrantyClaimRecord createClaim(DeviceOwnership device, String reason) {
        WarrantyClaimRecord claim = new WarrantyClaimRecord();
        claim.setDevice(device);
        claim.setClaimReason(reason);
        claim.setApproved(false);
        return repository.save(claim);
    }

    @Override
    public List<WarrantyClaimRecord> getAllClaims() {
        return repository.findAll();
    }

    @Override
    public WarrantyClaimRecord getClaimById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Claim not found"));
    }

    @Override
    public WarrantyClaimRecord approveClaim(Long id) {
        WarrantyClaimRecord claim = getClaimById(id);
        claim.setApproved(true);
        return repository.save(claim);
    }
}
