package com.hackathon1.demo.Request.Service;

import com.hackathon1.demo.Request.Dto.RequestRequestDTO;
import com.hackathon1.demo.Request.Dto.RequestResponseDTO;

import java.util.List;

public interface RequestService {

    RequestResponseDTO create(RequestRequestDTO dto);
    List<RequestResponseDTO> getAll();
    List<RequestResponseDTO> getByUser(Long userId);
}