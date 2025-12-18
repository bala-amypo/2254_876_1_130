package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class StolenDeviceReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;

    @ManyToOne
    private DeviceOwnershipRecord device;

    public StolenDeviceReport() {
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setDevice(DeviceOwnershipRecord device) {
        this.device = device;
    }
}
