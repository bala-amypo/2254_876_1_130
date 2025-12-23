package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceOwnershipController {

    private final DeviceOwnershipService deviceOwnershipService;

    public DeviceOwnershipController(DeviceOwnershipService deviceOwnershipService) {
        this.deviceOwnershipService = deviceOwnershipService;
    }

    // Register a new device
    @PostMapping
    public ResponseEntity<DeviceOwnershipRecord> registerDevice(
            @RequestBody DeviceOwnershipRecord deviceOwnershipRecord) {

        DeviceOwnershipRecord savedDevice =
                deviceOwnershipService.registerDevice(deviceOwnershipRecord);

        return ResponseEntity.ok(savedDevice);
    }

    // Get all devices
    @GetMapping
    public ResponseEntity<List<DeviceOwnershipRecord>> getAllDevices() {
        return ResponseEntity.ok(deviceOwnershipService.getAllDevices());
    }

    // Get device by serial number
    @GetMapping("/{serialNumber}")
    public ResponseEntity<DeviceOwnershipRecord> getDeviceBySerial(
            @PathVariable String serialNumber) {

        return ResponseEntity.ok(
                deviceOwnershipService.getBySerial(serialNumber)
        );
    }

    // Update device active status
    @PutMapping("/{id}/status")
    public ResponseEntity<DeviceOwnershipRecord> updateDeviceStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {

        DeviceOwnershipRecord updatedDevice =
                deviceOwnershipService.updateDeviceStatus(id, active);

        return ResponseEntity.ok(updatedDevice);
    }
}
