package com.hackathon1.demo.User.domain;

public record UserConsumptionDTO(
        Long userId,
        Map<ModelType, Integer> totalRequestsPerModel,
        Map<ModelType, Integer> totalTokensPerModel
) {}