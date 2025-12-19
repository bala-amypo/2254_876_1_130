package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.service.WarrantyClaimService;

@RestController
@RequestMapping("/api/warranty")
public class WarrantyClaimController {

    private final WarrantyClaimService service;

    public WarrantyClaimController(WarrantyClaimService service) {
        this.service = service;
    }

    @GetMapping("/check/{serialNumber}")
    public boolean checkWarranty(@PathVariable String serialNumber) {
        return service.isWarrantyValid(serialNumber);
    }
}
