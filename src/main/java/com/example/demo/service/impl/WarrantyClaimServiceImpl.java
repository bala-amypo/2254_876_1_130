package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.StolenDeviceReport;
import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.DeviceOwnershipRepository;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.repository.WarrantyClaimRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WarrantyClaimServiceImpl {

    private final WarrantyClaimRepository warrantyRepo;
    private final StolenDeviceReportRepository stolenRepo;
    private final DeviceOwnershipRepository deviceRepo;

    public WarrantyClaimServiceImpl(WarrantyClaimRepository warrantyRepo,
                                    StolenDeviceReportRepository stolenRepo,
                                    DeviceOwnershipRepository deviceRepo) {
        this.warrantyRepo = warrantyRepo;
        this.stolenRepo = stolenRepo;
        this.deviceRepo = deviceRepo;
    }

    public boolean isDeviceStolen(String serialNumber) {
        Optional<StolenDeviceReport> stolen = stolenRepo.findBySerialNumber(serialNumber);
        return stolen.isPresent();
    }

    public boolean isWarrantyValid(String serialNumber) {
        Optional<DeviceOwnershipRecord> deviceOpt = deviceRepo.findBySerialNumber(serialNumber);
        if (deviceOpt.isEmpty()) return false;
        DeviceOwnershipRecord device = deviceOpt.get();
        return device.getWarrantyExpiration().isAfter(java.time.LocalDate.now());
    }

    public void saveWarrantyClaim(WarrantyClaimRecord claim) {
        warrantyRepo.save(claim);
    }
}
