package com.example.demo.controller;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.service.StolenDeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stolen-devices")
public class StolenDeviceController {

    private final StolenDeviceService stolenDeviceService;

    public StolenDeviceController(StolenDeviceService stolenDeviceService) {
        this.stolenDeviceService = stolenDeviceService;
    }

    // Report a stolen device
    @PostMapping
    public ResponseEntity<StolenDeviceReport> reportStolenDevice(
            @RequestBody StolenDeviceReport report) {

        StolenDeviceReport savedReport = stolenDeviceService.reportStolen(report);
        return ResponseEntity.ok(savedReport);
    }

    // Get all stolen reports
    @GetMapping
    public ResponseEntity<List<StolenDeviceReport>> getAllReports() {
        return ResponseEntity.ok(stolenDeviceService.getAllReports());
    }

    // Get stolen report by ID
    @GetMapping("/{id}")
    public ResponseEntity<StolenDeviceReport> getReportById(@PathVariable Long id) {
        return stolenDeviceService.getReportById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("Device not found"));
    }

    // Get reports by device serial number
    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<List<StolenDeviceReport>> getReportsBySerial(
            @PathVariable String serialNumber) {

        return ResponseEntity.ok(stolenDeviceService.getReportsBySerial(serialNumber));
    }
}
