package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceOwnershipRecord {

    private String deviceId;
    private String owner;

    @Builder.Default
    private boolean verified = false;

    @Builder.Default
    private int warrantyMonths = 12;
}
