package com.example.demo.controller;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.service.StolenDeviceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stolen")
public class StolenDeviceController {

    private final StolenDeviceService stolenService;

    public StolenDeviceController(StolenDeviceService stolenService) {
        this.stolenService = stolenService;
    }

    @PostMapping("/report")
    public StolenDeviceReport reportStolen(@RequestBody StolenDeviceReport report) {
        return stolenService.reportStolenDevice(report);
    }

    @GetMapping("/{id}")
    public Optional<StolenDeviceReport> getReportById(@PathVariable Long id) {
        return stolenService.getReportById(id);
    }

    @GetMapping("/serial/{serial}")
    public List<StolenDeviceReport> getReportsBySerial(@PathVariable String serial) {
        return stolenService.getReportsBySerial(serial);
    }

    @GetMapping("/all")
    public List<StolenDeviceReport> getAllReports() {
        return stolenService.getAllReports();
    }
}
