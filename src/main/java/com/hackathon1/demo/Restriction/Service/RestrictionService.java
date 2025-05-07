package com.hackathon1.demo.Restriction.Service;

import com.hackathon1.demo.Restriction.Dto.RestrictionRequestDTO;
import com.hackathon1.demo.Restriction.Dto.RestrictionResponseDTO;

import java.util.List;

public interface RestrictionService {
    RestrictionResponseDTO create(RestrictionRequestDTO dto);
    List<RestrictionResponseDTO> getAll();
    List<RestrictionResponseDTO> getByCompany(Long companyId);
    RestrictionResponseDTO update(Long id, RestrictionRequestDTO dto);
    void toggleStatus(Long id);
}