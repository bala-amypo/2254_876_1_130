package com.example.demo.service.impl;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
