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
public class WarrantyClaimRecord {

    private String claimNumber;
    private String description;

    @Builder.Default
    private boolean active = true;

    @Builder.Default
    private int priority = 1;
}
