package com.example.demo.controller;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.service.WarrantyClaimService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
@Tag(name = "Claim")
public class WarrantyClaimController {

    private final WarrantyClaimService service;

    public WarrantyClaimController(WarrantyClaimService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> submit(@RequestBody WarrantyClaimRecord claim) {
        return ResponseEntity.ok(service.submitClaim(claim));
    }

    @GetMapping
    public ResponseEntity<List<WarrantyClaimRecord>> getAll() {
        return ResponseEntity.ok(service.getAllClaims());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getClaimById(id));
    }

    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<List<WarrantyClaimRecord>> getBySerial(
            @PathVariable String serialNumber) {
        return ResponseEntity.ok(service.getClaimsBySerial(serialNumber));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable Long id,
                                          @RequestParam String status) {
        return ResponseEntity.ok(service.updateClaimStatus(id, status));
    }
}
