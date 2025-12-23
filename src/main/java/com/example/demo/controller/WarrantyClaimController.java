package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class WarrantyClaimController {

    @Autowired
    private WarrantyClaimService claimService;

    @PostMapping("/submit")
    public WarrantyClaimRecord submitClaim(@RequestParam String description, @RequestBody DeviceOwnershipRecord device) {
        return claimService.submitClaim(description, device);
    }

    @GetMapping("/all")
    public List<WarrantyClaimRecord> getAllClaims() {
        return claimService.getAllClaims();
    }

    @GetMapping("/{id}")
    public WarrantyClaimRecord getClaimById(@PathVariable Long id) {
        return claimService.getClaimById(id);
    }

    @PutMapping("/update-status/{id}")
    public WarrantyClaimRecord updateClaimStatus(@PathVariable Long id, @RequestParam String status) {
        return claimService.updateClaimStatus(id, status);
    }

    @GetMapping("/device/{serialNumber}")
    public List<WarrantyClaimRecord> getClaimsBySerial(@PathVariable String serialNumber) {
        return claimService.getClaimsBySerial(serialNumber);
    }
}
