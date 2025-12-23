package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.StolenDeviceReport;
import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import com.example.demo.service.WarrantyClaimService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRecordRepository claimRepository;
    private final DeviceOwnershipRecordRepository deviceRepository;
    private final StolenDeviceReportRepository stolenRepository;

    public WarrantyClaimServiceImpl(WarrantyClaimRecordRepository claimRepository,
                                    DeviceOwnershipRecordRepository deviceRepository,
                                    StolenDeviceReportRepository stolenRepository) {
        this.claimRepository = claimRepository;
        this.deviceRepository = deviceRepository;
        this.stolenRepository = stolenRepository;
    }

    @Override
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {
        // Check if device exists
        DeviceOwnershipRecord device = deviceRepository.findBySerialNumber(claim.getSerialNumber())
                .orElseThrow(() -> new NoSuchElementException("Offer not found"));

        // Initialize claim status
        claim.setStatus("PENDING");
        claim.setSubmittedAt(LocalDateTime.now());
        claim.setCreatedAt(LocalDateTime.now());

        boolean flag = false;

        // 1️⃣ Check if device is reported stolen
        if (stolenRepository.existsBySerialNumber(device.getSerialNumber())) {
            flag = true;
        }

        // 2️⃣ Check warranty expiration
        if (device.getWarrantyExpiration() != null &&
                device.getWarrantyExpiration().isBefore(LocalDate.now())) {
            flag = true;
        }

        // 3️⃣ Check duplicate claim (same serial + reason)
        if (claimRepository.existsBySerialNumberAndClaimReason(
                claim.getSerialNumber(), claim.getClaimReason())) {
            flag = true;
        }

        if (flag) {
            claim.setStatus("FLAGGED");
        }

        return claimRepository.save(claim);
    }

    @Override
    public WarrantyClaimRecord updateClaimStatus(Long claimId, String status) {
        WarrantyClaimRecord claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new NoSuchElementException("Request not found"));
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
