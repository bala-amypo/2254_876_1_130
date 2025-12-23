package com.example.demo.controller;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class WarrantyClaimController {

    private final WarrantyClaimService claimService;

    public WarrantyClaimController(WarrantyClaimService claimService) {
        this.claimService = claimService;
    }

    // Submit a warranty claim
    @PostMapping
    public ResponseEntity<WarrantyClaimRecord> submitClaim(
            @RequestBody WarrantyClaimRecord claim) {

        WarrantyClaimRecord savedClaim = claimService.submitClaim(claim);
        return ResponseEntity.ok(savedClaim);
    }

    // List all claims
    @GetMapping
    public ResponseEntity<List<WarrantyClaimRecord>> getAllClaims() {
        return ResponseEntity.ok(claimService.getAllClaims());
    }

    // Get claim by ID
    @GetMapping("/{id}")
    public ResponseEntity<WarrantyClaimRecord> getClaimById(@PathVariable Long id) {
        return claimService.getClaimById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("Request not found"));
    }

    // Get claims by device serial number
    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<List<WarrantyClaimRecord>> getClaimsBySerial(
            @PathVariable String serialNumber) {

        return ResponseEntity.ok(claimService.getClaimsBySerial(serialNumber));
    }

    // Update claim status (ADMIN only)
    @PutMapping("/{id}/status")
    public ResponseEntity<WarrantyClaimRecord> updateClaimStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        WarrantyClaimRecord updatedClaim = claimService.updateClaimStatus(id, status);
        return ResponseEntity.ok(updatedClaim);
    }
}
