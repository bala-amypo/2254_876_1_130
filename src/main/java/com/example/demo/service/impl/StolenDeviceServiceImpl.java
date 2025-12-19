package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StolenDeviceServiceImpl {

    @Autowired
    private DeviceOwnershipRepository deviceRepo;

    public void printAllSerialNumbers() {
        List<DeviceOwnershipRecord> devices = deviceRepo.findAll();
        for (DeviceOwnershipRecord d : devices) {
            // Correct method
            System.out.println(d.getSerialNumber());
        }
    }
}
