package com.hackathon1.demo.Company.Service;

import com.hackathon1.demo.Company.Dto.CompanyRequestDTO;
import com.hackathon1.demo.Company.Dto.CompanyResponseDTO;

import java.util.List;

public interface CompanyService {

    CompanyResponseDTO create(CompanyRequestDTO dto);
    List<CompanyResponseDTO> getAll();
    CompanyResponseDTO getById(Long id);
    CompanyResponseDTO update(Long id, CompanyRequestDTO dto);
    void toggleStatus(Long id);
}
