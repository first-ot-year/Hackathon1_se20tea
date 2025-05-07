package com.hackathon1.demo.UserLimit.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLimitResponseDTO {
    private Long id;
    private int dailyLimit;
    private int monthlyLimit;
    private int tokensLimit;
    private String userEmail;
}
