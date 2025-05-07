package com.hackathon1.demo.UserLimit.Service;

import com.hackathon1.demo.UserLimit.Dto.UserLimitRequestDTO;

import com.hackathon1.demo.UserLimit.Dto.UserLimitResponseDTO;

import java.util.List;

public interface UserLimitService {
    UserLimitResponseDTO create(UserLimitRequestDTO dto);
    List<UserLimitResponseDTO> getAll();
    UserLimitResponseDTO getByUserId(Long userId);
}
