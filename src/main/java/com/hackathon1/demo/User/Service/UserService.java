package com.hackathon1.demo.User.Service;

import com.hackathon1.demo.User.Dto.UserRequestDTO;
import com.hackathon1.demo.User.Dto.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO create(UserRequestDTO dto);
    List<UserResponseDTO> getAll();
    UserResponseDTO getById(Long id);
    UserResponseDTO update(Long id, UserRequestDTO dto);
    void toggleStatus(Long id);
}
