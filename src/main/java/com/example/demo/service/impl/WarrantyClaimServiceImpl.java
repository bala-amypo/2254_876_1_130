package com.example.demo.service.impl;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRecordRepository claimRepository;

    public WarrantyClaimServiceImpl(WarrantyClaimRecordRepository claimRepository) {
        this.claimRepository = claimRepository;
    }

    @Override
    public List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber) {
        return claimRepository.findByDeviceSerialNumber(serialNumber);
    }

    @Override
    public WarrantyClaimRecord resolveClaim(WarrantyClaimRecord claim) {
        claim.setStatus("RESOLVED");
        return claimRepository.save(claim);
    }

    @Override
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {
        claim.setStatus("PENDING");
        return claimRepository.save(claim);
    }

    @Override
    public List<WarrantyClaimRecord> getAllClaims() {
        return claimRepository.findAll();
    }

    @Override
    public Optional<WarrantyClaimRecord> getClaimById(Long id) {
        return claimRepository.findById(id);
    }

    @Override
    public WarrantyClaimRecord updateClaimStatus(Long id, String status) {
        Optional<WarrantyClaimRecord> opt = claimRepository.findById(id);
        if(opt.isPresent()) {
            WarrantyClaimRecord claim = opt.get();
            claim.setStatus(status);
            return claimRepository.save(claim);
        }
        return null;
    }
}
