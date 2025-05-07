package com.hackathon1.demo.UserLimit.Dto;

import lombok.Data;

@Data
public class UserLimitRequestDTO {
    private int dailyLimit;
    private int monthlyLimit;
    private int tokensLimit;
    private Long userId;
}
