package com.example.demo.service.impl;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRecordRepository claimRepository;

    @Autowired
    public WarrantyClaimServiceImpl(WarrantyClaimRecordRepository claimRepository) {
        this.claimRepository = claimRepository;
    }

    @Override
    public WarrantyClaimRecord createClaim(WarrantyClaimRecord claim) {
        // Set default status if not provided
        if (claim.getClaimStatus() == null) {
            claim.setClaimStatus("NEW");
        }
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
        Optional<WarrantyClaimRecord> optionalClaim = claimRepository.findById(id);
        if (optionalClaim.isPresent()) {
            WarrantyClaimRecord claim = optionalClaim.get();
            claim.setClaimStatus(status);  // ✅ Updated to match your model
            return claimRepository.save(claim);
        }
        return null;
    }

    @Override
    public void deleteClaim(Long id) {
        claimRepository.deleteById(id);
    }

    @Override
    public String getClaimReason(Long id) {
        Optional<WarrantyClaimRecord> optionalClaim = claimRepository.findById(id);
        return optionalClaim.map(WarrantyClaimRecord::getClaimReason).orElse(null);
    }
}
