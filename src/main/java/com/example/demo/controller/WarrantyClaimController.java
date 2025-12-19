package com.example.demo.controller;

import com.example.demo.entity.WarrantyClaimRecord;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class WarrantyClaimController {

    private final WarrantyClaimService service;

    public WarrantyClaimController(WarrantyClaimService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<WarrantyClaimRecord> submitClaim(
            @RequestBody WarrantyClaimRecord claim) {
        return ResponseEntity.ok(service.submitClaim(claim));
    }

    @GetMapping
    public ResponseEntity<List<WarrantyClaimRecord>> getAllClaims() {
        return ResponseEntity.ok(service.getAllClaims());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WarrantyClaimRecord> getClaimById(@PathVariable Long id) {
        return service.getClaimById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<List<WarrantyClaimRecord>> getBySerial(
            @PathVariable String serialNumber) {
        return ResponseEntity.ok(service.getClaimsBySerial(serialNumber));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<WarrantyClaimRecord> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return ResponseEntity.ok(service.updateClaimStatus(id, status));
    }
}
