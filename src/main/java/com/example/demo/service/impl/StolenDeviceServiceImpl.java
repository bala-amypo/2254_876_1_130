// package com.example.demo.service.impl;

// import org.springframework.stereotype.Service;

// import com.example.demo.repository.DeviceOwnershipRecordRepository;
// import com.example.demo.service.StolenDeviceService;

// @Service
// public class StolenDeviceServiceImpl implements StolenDeviceService {

//     private final DeviceOwnershipRecordRepository repository;

//     public StolenDeviceServiceImpl(
//             DeviceOwnershipRecordRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public boolean isStolen(String serialNumber) {
//         return repository.findBySerialNumber(serialNumber)
//                 .map(device -> !device.isActive())
//                 .orElse(false);
//     }
// }
