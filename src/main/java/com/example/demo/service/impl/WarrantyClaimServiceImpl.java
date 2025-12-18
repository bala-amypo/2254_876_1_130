package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import com.example.demo.service.WarrantyClaimService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRecordRepository claimRepository;
    private final DeviceOwnershipRecordRepository deviceRepository;

    @Override
    public WarrantyClaimRecord createClaim(Long deviceId, String claimReason) {
        DeviceOwnershipRecord device = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new IllegalArgumentException("Device not found with ID: " + deviceId));

        // Use isActive() instead of getActive()
        if (!device.isActive()) {
            throw new IllegalStateException("Device is not active, cannot create claim");
        }

        WarrantyClaimRecord claim = new WarrantyClaimRecord();
        claim.setDevice(device);
        claim.setClaimReason(claimReason);
        claim.setResolved(false);
        return claimRepository.save(claim);
    }

    @Override
    public List<WarrantyClaimRecord> getAllClaims() {
        return claimRepository.findAll();
    }
}
