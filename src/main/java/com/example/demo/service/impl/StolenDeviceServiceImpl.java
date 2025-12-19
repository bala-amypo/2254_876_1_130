package com.example.demo.service.impl;

import com.example.demo.entity.DeviceOwnershipRecord;
import com.example.demo.entity.StolenDeviceReport;
import com.example.demo.repository.DeviceOwnershipRepository;
import com.example.demo.repository.StolenDeviceRepository;
import com.example.demo.service.StolenDeviceService;
import org.springframework.stereotype.Service;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceRepository stolenDeviceRepository;
    private final DeviceOwnershipRepository deviceOwnershipRepository;

    // ✅ Constructor injection (NO @Autowired)
    public StolenDeviceServiceImpl(
            StolenDeviceRepository stolenDeviceRepository,
            DeviceOwnershipRepository deviceOwnershipRepository
    ) {
        this.stolenDeviceRepository = stolenDeviceRepository;
        this.deviceOwnershipRepository = deviceOwnershipRepository;
    }

    @Override
    public StolenDeviceReport reportStolenDevice(String serialNumber, String reason) {

        // 🔹 Find device by serial number
        DeviceOwnershipRecord device = deviceOwnershipRepository
                .findBySerialNumber(serialNumber)
                .orElseThrow(() ->
                        new RuntimeException("Device not found with serial: " + serialNumber)
                );

        // 🔹 Create stolen report
        StolenDeviceReport report = new StolenDeviceReport();
        report.setReportReason(reason);

        // 🔹 Set relationship (IMPORTANT)
        report.setDeviceOwnershipRecord(device);

        return stolenDeviceRepository.save(report);
    }
}
