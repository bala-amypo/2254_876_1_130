package com.example.demo.service.impl;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarrantyClaimServiceImpl {

    @Autowired
    private WarrantyClaimRecordRepository claimRepo;

    public List<WarrantyClaimRecord> getClaimsBySerialNumber(String serialNumber) {
        // Use repository method returning List
        return claimRepo.findByDeviceSerialNumber(serialNumber);
    }

    public void processClaim(Long claimId) {
        Optional<WarrantyClaimRecord> claimOpt = claimRepo.findById(claimId);
        claimOpt.ifPresent(claim -> {
            String serial = claim.getDevice().getSerialNumber();
            // Example: check warranty expiration
            if (claim.getDevice().getWarrantyExpiration().isBefore(java.time.LocalDate.now())) {
                claim.setStatus("Expired");
            } else {
                claim.setStatus("Active");
            }
            System.out.println("Processed claim for device: " + serial);
        });
    }
}
