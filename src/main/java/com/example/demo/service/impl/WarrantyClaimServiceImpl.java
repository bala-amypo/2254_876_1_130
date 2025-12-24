package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.repository.FraudAlertRecordRepository;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {
    private final WarrantyClaimRecordRepository claimRepo;
    private final DeviceOwnershipRecordRepository deviceRepo;
    private final StolenDeviceReportRepository stolenRepo;
    private final FraudAlertRecordRepository alertRepo;
    private final FraudRuleRepository ruleRepo;
    
    public WarrantyClaimServiceImpl(WarrantyClaimRecordRepository claimRepo,
                                   DeviceOwnershipRecordRepository deviceRepo,
                                   StolenDeviceReportRepository stolenRepo,
                                   FraudAlertRecordRepository alertRepo,
                                   FraudRuleRepository ruleRepo) {
        this.claimRepo = claimRepo;
        this.deviceRepo = deviceRepo;
        this.stolenRepo = stolenRepo;
        this.alertRepo = alertRepo;
        this.ruleRepo = ruleRepo;
    }
    
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {
        DeviceOwnershipRecord device = deviceRepo.findBySerialNumber(claim.getSerialNumber())
            .orElseThrow(() -> new NoSuchElementException("Device not found"));
        
        // Check for duplicate claims
        if (claimRepo.existsBySerialNumberAndClaimReason(claim.getSerialNumber(), claim.getClaimReason())) {
            claim.setStatus("FLAGGED");
        }
        // Check if warranty expired
        else if (device.getWarrantyExpiration() != null && device.getWarrantyExpiration().isBefore(LocalDate.now())) {
            claim.setStatus("FLAGGED");
        }
        // Check if device is stolen
        else if (stolenRepo.existsBySerialNumber(claim.getSerialNumber())) {
            claim.setStatus("FLAGGED");
        }
        
        return claimRepo.save(claim);
    }
    
    public WarrantyClaimRecord updateClaimStatus(Long id, String status) {
        WarrantyClaimRecord claim = claimRepo.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Claim not found"));
        claim.setStatus(status);
        return claimRepo.save(claim);
    }
    
    public Optional<WarrantyClaimRecord> getClaimById(Long id) {
        return claimRepo.findById(id);
    }
    
    public List<WarrantyClaimRecord> getAllClaims() {
        return claimRepo.findAll();
    }
    
    public List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber) {
        return claimRepo.findBySerialNumber(serialNumber);
    }
}