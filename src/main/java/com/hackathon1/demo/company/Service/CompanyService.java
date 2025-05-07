package com.hackathon1.demo.company.Service;

import com.hackathon1.demo.company.Dto.CompanyRequestDTO;
import com.hackathon1.demo.company.Dto.CompanyResponseDTO;

import java.util.List;

public interface CompanyService {

    CompanyResponseDTO create(CompanyRequestDTO dto);
    List<CompanyResponseDTO> getAll();
    CompanyResponseDTO getById(Long id);
    CompanyResponseDTO update(Long id, CompanyRequestDTO dto);
    void toggleStatus(Long id);
}