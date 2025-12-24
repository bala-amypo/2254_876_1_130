package com.example.demo.controller;

/* ===== IMPORTS ===== */
import com.example.demo.model.WarrantyClaimRecord;
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
    public ResponseEntity<WarrantyClaimRecord> submit(@RequestBody WarrantyClaimRecord claim) {
        return ResponseEntity.ok(service.submitClaim(claim));
    }

    @GetMapping
    public ResponseEntity<List<WarrantyClaimRecord>> getAll() {
        return ResponseEntity.ok(service.getAllClaims());
    }
}
