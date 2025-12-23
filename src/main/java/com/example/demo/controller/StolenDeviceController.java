package com.example.demo.controller;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.service.StolenDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stolen-devices")
public class StolenDeviceController {

    @Autowired
    private StolenDeviceService stolenDeviceService;

    @PostMapping("/report")
    public ResponseEntity<StolenDeviceReport> reportStolen(@RequestBody StolenDeviceReport report) {
        return ResponseEntity.ok(stolenDeviceService.addReport(report));
    }

    @GetMapping
    public ResponseEntity<List<StolenDeviceReport>> getAllReports() {
        return ResponseEntity.ok(stolenDeviceService.getAllReports());
    }

    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<List<StolenDeviceReport>> getReportsBySerial(@PathVariable String serialNumber) {
        return ResponseEntity.ok(stolenDeviceService.getReportsBySerial(serialNumber));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StolenDeviceReport> getReportById(@PathVariable Long id) {
        StolenDeviceReport report = stolenDeviceService.getReportById(id);
        if (report == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(report);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        stolenDeviceService.deleteReport(id);
        return ResponseEntity.noContent().build();
    }
}
