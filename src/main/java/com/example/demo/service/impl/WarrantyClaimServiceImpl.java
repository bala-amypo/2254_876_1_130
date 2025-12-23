package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.FraudAlertRecord;
import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.repository.FraudAlertRecordRepository;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import com.example.demo.service.WarrantyClaimService;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRecordRepository claimRepository;
    private final DeviceOwnershipRecordRepository deviceRepository;
    private final StolenDeviceReportRepository stolenRepository;
    private final FraudAlertRecordRepository alertRepository;
    private final FraudRuleRepository ruleRepository;

    public WarrantyClaimServiceImpl(WarrantyClaimRecordRepository claimRepository,
                                    DeviceOwnershipRecordRepository deviceRepository,
                                    StolenDeviceReportRepository stolenRepository,
                                    FraudAlertRecordRepository alertRepository,
                                    FraudRuleRepository ruleRepository) {
        this.claimRepository = claimRepository;
        this.deviceRepository = deviceRepository;
        this.stolenRepository = stolenRepository;
        this.alertRepository = alertRepository;
        this.ruleRepository = ruleRepository;
    }

    @Override
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {

        DeviceOwnershipRecord device = deviceRepository
                .findBySerialNumber(claim.getSerialNumber())
                .orElseThrow(() -> new NoSuchElementException("Offer not found"));

        claim.setDevice(device);

        boolean flagged = false;

        if (stolenRepository.existsBySerialNumber(claim.getSerialNumber())) {
            flagged = true;
            createAlert(claim, "STOLEN_DEVICE", "CRITICAL");
        }

        if (device.getWarrantyExpiration().isBefore(LocalDate.now())) {
            flagged = true;
            createAlert(claim, "WARRANTY_EXPIRED", "HIGH");
        }

        if (claimRepository.existsBySerialNumberAndClaimReason(
                claim.getSerialNumber(), claim.getClaimReason())) {
            flagged = true;
            createAlert(claim, "DUPLICATE_CLAIM", "MEDIUM");
        }

        claim.setStatus(flagged ? "FLAGGED" : "PENDING");

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

    private void createAlert(WarrantyClaimRecord claim, String type, String severity) {
        FraudAlertRecord alert = new FraudAlertRecord(
                claim.getId(),
                claim.getSerialNumber(),
                type,
                severity
        );
        alert.setClaim(claim);
        alertRepository.save(alert);
    }
}
