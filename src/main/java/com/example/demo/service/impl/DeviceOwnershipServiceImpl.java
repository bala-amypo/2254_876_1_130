// package com.example.demo.service.impl;

// import org.springframework.stereotype.Service;

// import com.example.demo.model.DeviceOwnershipRecord;
// import com.example.demo.repository.DeviceOwnershipRecordRepository;
// import com.example.demo.service.DeviceOwnershipService;

// @Service
// public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

//     private final DeviceOwnershipRecordRepository repository;

//     public DeviceOwnershipServiceImpl(
//             DeviceOwnershipRecordRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public DeviceOwnershipRecord registerDevice(
//             DeviceOwnershipRecord device) {

//         device.setActive(true);
//         return repository.save(device);
//     }
// }
