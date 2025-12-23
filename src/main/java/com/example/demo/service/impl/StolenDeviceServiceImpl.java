package com.example.demo.service.impl;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.StolenDeviceReportRepository; // updated
import com.example.demo.service.StolenDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    @Autowired
    private StolenDeviceReportRepository repository; // updated

    @Override
    public StolenDeviceReport addReport(StolenDeviceReport report) {
        return repository.save(report);
    }

    @Override
    public List<StolenDeviceReport> getAllReports() {
        return repository.findAll();
    }

    @Override
    public StolenDeviceReport getReportById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteReport(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<StolenDeviceReport> getReportsBySerial(String serialNumber) {
        return repository.findByDeviceSerialNumber(serialNumber);
    }
}
