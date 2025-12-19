package com.example.demo.controller;

import com.example.demo.entity.StolenDeviceReport;
import com.example.demo.service.StolenDeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stolen-devices")
public class StolenDeviceController {

    private final StolenDeviceService stolenService;

    public StolenDeviceController(StolenDeviceService stolenService) {
        this.stolenService = stolenService;
    }

    @PostMapping("/")
    public ResponseEntity<StolenDeviceReport> reportStolen(@RequestBody StolenDeviceReport report) {
        return ResponseEntity.ok(stolenService.reportStolen(report));
    }

    @GetMapping("/")
    public ResponseEntity<List<StolenDeviceReport>> getAllReports() {
        return ResponseEntity.ok(stolenService.getAllReports());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StolenDeviceReport> getReportById(@PathVariable Long id) {
        return stolenService.getReportById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<List<StolenDeviceReport>> getReportsBySerial(@PathVariable String serialNumber) {
        return ResponseEntity.ok(stolenService.getReportsBySerial(serialNumber));
    }
}
