package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeviceOwnershipRecord {

    private Long id;
    private String serialNumber;
    private Boolean active;
}
