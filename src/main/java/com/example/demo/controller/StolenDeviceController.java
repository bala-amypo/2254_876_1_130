package com.example.demo.controller;

import com.example.demo.entity.StolenDeviceReport;
import com.example.demo.service.StolenDeviceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stolen-devices")
public class StolenDeviceController {

    private final StolenDeviceService stolenService;

    public StolenDeviceController(StolenDeviceService stolenService) {
        this.stolenService = stolenService;
    }

    @PostMapping("/report")
    public StolenDeviceReport reportStolen(@RequestBody StolenDeviceReport report) {
        return stolenService.reportStolenDevice(report); // corrected method name
    }

    @GetMapping("/all")
    public List<StolenDeviceReport> getAllReports() {
        return stolenService.getAllStolenDevices(); // corrected method name
    }

    @GetMapping("/{id}")
    public StolenDeviceReport getReportById(@PathVariable Long id) {
        return stolenService.getAllStolenDevices().stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/serial/{serial}")
    public boolean isDeviceStolen(@PathVariable String serial) {
        return stolenService.isDeviceStolen(serial); // corrected method name
    }
}
