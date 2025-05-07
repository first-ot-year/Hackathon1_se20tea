package com.hackathon1.demo.Request.Dto;

import lombok.Data;

@Data
public class RequestRequestDTO {
    private String model;
    private String prompt;
    private int tokensUsed;
    private Long userId;
}
