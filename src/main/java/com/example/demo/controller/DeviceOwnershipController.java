package com.example.demo.controller;

import com.example.demo.model.DeviceOwnership;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deviceOwnership")
public class DeviceOwnershipController {

    private final DeviceOwnershipService deviceOwnershipService;

    public DeviceOwnershipController(DeviceOwnershipService deviceOwnershipService) {
        this.deviceOwnershipService = deviceOwnershipService;
    }

    @PostMapping("/register")
    public DeviceOwnership registerDevice(@RequestBody DeviceOwnership device) {
        return deviceOwnershipService.registerDevice(device);
    }

    @GetMapping("/all")
    public List<DeviceOwnership> getAllDevices() {
        return deviceOwnershipService.getAllDevices();
    }

    @GetMapping("/{serialNumber}")
    public DeviceOwnership getBySerial(@PathVariable String serialNumber) {
        return deviceOwnershipService.getBySerial(serialNumber);
    }

    @PatchMapping("/{id}/status")
    public DeviceOwnership updateDeviceStatus(@PathVariable Long id, @RequestParam boolean stolen) {
        return deviceOwnershipService.updateDeviceStatus(id, stolen);
    }
}
