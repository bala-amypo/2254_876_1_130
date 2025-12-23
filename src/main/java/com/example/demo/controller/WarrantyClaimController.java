package com.example.demo.controller;

import com.example.demo.entity.WarrantyClaimRecord;
import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warranty")
public class WarrantyClaimController {

    @Autowired
    private WarrantyClaimService warrantyClaimService;

    @PostMapping("/file")
    public ResponseEntity<WarrantyClaimRecord> fileClaim(@RequestBody WarrantyClaimRecord claimRecord) {
        WarrantyClaimRecord saved = warrantyClaimService.fileClaim(claimRecord);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/all")
    public ResponseEntity<List<WarrantyClaimRecord>> getAllClaims() {
        return ResponseEntity.ok(warrantyClaimService.getAllClaims());
    }

    @GetMapping("/device")
    public ResponseEntity<List<WarrantyClaimRecord>> getClaimsByDevice(@RequestBody DeviceOwnershipRecord deviceOwnershipRecord) {
        List<WarrantyClaimRecord> claims = warrantyClaimService.getClaimsByDevice(deviceOwnershipRecord);
        return ResponseEntity.ok(claims);
    }
}
