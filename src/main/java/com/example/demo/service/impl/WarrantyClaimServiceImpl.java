package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import com.example.demo.service.WarrantyClaimService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRecordRepository claimRepository;
    private final DeviceOwnershipRecordRepository deviceRepository;
    private final StolenDeviceReportRepository stolenRepository;

    @Override
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {

        DeviceOwnershipRecord device = deviceRepository
                .findBySerialNumber(claim.getSerialNumber())
                .orElseThrow(() -> new NoSuchElementException("Device not found"));

        // Default status
        claim.setStatus("APPROVED");

        // 1️⃣ Check if device is active
        if (!device.getActive()) {
            claim.setStatus("FLAGGED");
        }

        // 2️⃣ Check if device reported stolen
        boolean stolen = stolenRepository.existsBySerialNumber(device.getSerialNumber());
        if (stolen) {
            claim.setStatus("FLAGGED");
        }

        // 3️⃣ Check warranty expiration
        LocalDate today = LocalDate.now();
        if (device.getWarrantyExpiration().isBefore(today)) {
            claim.setStatus("FLAGGED");
        }

        // 4️⃣ Check duplicate claim
        boolean duplicate = claimRepository.existsBySerialNumberAndClaimReason(
                claim.getSerialNumber(),
                claim.getClaimReason()
        );
        if (duplicate) {
            claim.setStatus("FLAGGED");
        }

        claim.setDevice(device);
        claim.setSubmittedAt(LocalDateTime.now());

        return claimRepository.save(claim);
    }

    @Override
    public WarrantyClaimRecord updateClaimStatus(Long claimId, String status) {

        WarrantyClaimRecord claim = claimRepository
                .findById(claimId)
                .orElseThrow(() -> new NoSuchElementException("Claim not found"));

        claim.setStatus(status);
        return claimRepository.save(claim);
    }

    @Override
    public Optional<WarrantyClaimRecord> getClaimById(Long id) {
        return claimRepository.findById(id);
    }

    @Override
    public List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber) {
        return claimRepository.findBySerialNumber(serialNumber);
    }

    @Override
    public List<WarrantyClaimRecord> getAllClaims() {
        return claimRepository.findAll();
    }
}
