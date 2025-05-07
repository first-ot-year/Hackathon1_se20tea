package com.hackathon1.demo.Request.Dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class RequestResponseDTO {
    private Long id;
    private String model;
    private String prompt;
    private int tokensUsed;
    private LocalDateTime createdAt;
    private String userEmail;
}