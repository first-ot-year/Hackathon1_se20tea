package com.hackathon1.demo.Restriction.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RestrictionResponseDTO {
    private Long id;
    private String model;
    private int maxTokens;
    private boolean active;
    private String companyName;
}