package com.example.demo.controller;

import com.example.demo.service.impl.DeviceOwnershipServiceImpl;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceOwnershipController {
    private final DeviceOwnershipServiceImpl service;
    
    public DeviceOwnershipController(DeviceOwnershipServiceImpl service) {
        this.service = service;
    }
}
