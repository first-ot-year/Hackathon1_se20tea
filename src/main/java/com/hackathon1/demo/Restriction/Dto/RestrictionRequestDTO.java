package com.hackathon1.demo.Restriction.Dto;

import lombok.Data;

@Data
public class RestrictionRequestDTO {
    private String model;
    private int maxTokens;
    private boolean active;
    private Long companyId;
}