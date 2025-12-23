package com.example.demo.controller;

import com.example.demo.entity.WarrantyClaimRecord;
import com.example.demo.model.DeviceOwnership;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warranty")
public class WarrantyClaimController {

    private final WarrantyClaimService warrantyClaimService;

    public WarrantyClaimController(WarrantyClaimService warrantyClaimService) {
        this.warrantyClaimService = warrantyClaimService;
    }

    @PostMapping("/claim")
    public WarrantyClaimRecord createClaim(@RequestBody DeviceOwnership device, @RequestParam String reason) {
        return warrantyClaimService.createClaim(device, reason);
    }

    @GetMapping("/all")
    public List<WarrantyClaimRecord> getAllClaims() {
        return warrantyClaimService.getAllClaims();
    }

    @GetMapping("/{id}")
    public WarrantyClaimRecord getClaimById(@PathVariable Long id) {
        return warrantyClaimService.getClaimById(id);
    }

    @PatchMapping("/{id}/approve")
    public WarrantyClaimRecord approveClaim(@PathVariable Long id) {
        return warrantyClaimService.approveClaim(id);
    }
}
