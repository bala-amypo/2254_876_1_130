package com.example.demo.controller;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.service.StolenDeviceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stolen-devices")
@Tag(name = "StolenDevice", description = "Stolen device reporting APIs")
public class StolenDeviceController {

    private final StolenDeviceService stolenService;

    public StolenDeviceController(StolenDeviceService stolenService) {
        this.stolenService = stolenService;
    }

    @PostMapping
    public ResponseEntity<StolenDeviceReport> reportStolen(
            @RequestBody StolenDeviceReport report) {
        return ResponseEntity.ok(stolenService.reportStolen(report));
    }

    @GetMapping
    public ResponseEntity<List<StolenDeviceReport>> getAllReports() {
        return ResponseEntity.ok(stolenService.getAllReports());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StolenDeviceReport> getById(@PathVariable Long id) {
        return stolenService.getReportById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new java.util.NoSuchElementException("Request not found"));
    }

    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<List<StolenDeviceReport>> getBySerial(
            @PathVariable String serialNumber) {
        return ResponseEntity.ok(stolenService.getReportsBySerial(serialNumber));
    }
}
