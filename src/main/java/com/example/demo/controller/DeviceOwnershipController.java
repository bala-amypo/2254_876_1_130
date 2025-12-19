package com.example.demo.controller;

import com.example.demo.entity.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceOwnershipController {

    private final DeviceOwnershipService deviceService;

    public DeviceOwnershipController(DeviceOwnershipService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping("/")
    public ResponseEntity<DeviceOwnershipRecord> registerDevice(@RequestBody DeviceOwnershipRecord device) {
        return ResponseEntity.ok(deviceService.registerDevice(device));
    }

    @GetMapping("/")
    public ResponseEntity<List<DeviceOwnershipRecord>> getAllDevices() {
        return ResponseEntity.ok(deviceService.getAllDevices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceOwnershipRecord> getDeviceById(@PathVariable Long id) {
        return ResponseEntity.ok(deviceService.updateDeviceStatus(id, true));
    }

    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<DeviceOwnershipRecord> getDeviceBySerial(@PathVariable String serialNumber) {
        return ResponseEntity.ok(deviceService.getBySerial(serialNumber));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<DeviceOwnershipRecord> updateDeviceStatus(@PathVariable Long id,
                                                                    @RequestParam boolean active) {
        return ResponseEntity.ok(deviceService.updateDeviceStatus(id, active));
    }
}
