package com.hackathon1.demo.Restriction.Service;

import com.hackathon1.demo.Company.Repository.CompanyRepository;
import com.hackathon1.demo.Company.entity.Company;
import com.hackathon1.demo.Restriction.Dto.RestrictionRequestDTO;
import com.hackathon1.demo.Restriction.Dto.RestrictionResponseDTO;
import com.hackathon1.demo.Restriction.Repository.RestrictionRepository;
import com.hackathon1.demo.Restriction.entity.Restriction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestrictionServiceImpl implements RestrictionService {

    private final RestrictionRepository restrictionRepository;
    private final CompanyRepository companyRepository;

    @Override
    public RestrictionResponseDTO create(RestrictionRequestDTO dto) {
        Company company = companyRepository.findById(dto.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));

        Restriction restriction = Restriction.builder()
                .model(dto.getModel())
                .maxTokens(dto.getMaxTokens())
                .active(dto.isActive())
                .company(company)
                .build();

        return toResponse(restrictionRepository.save(restriction));
    }

    @Override
    public List<RestrictionResponseDTO> getAll() {
        return restrictionRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<RestrictionResponseDTO> getByCompany(Long companyId) {
        return restrictionRepository.findByCompanyId(companyId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public RestrictionResponseDTO update(Long id, RestrictionRequestDTO dto) {
        Restriction restriction = restrictionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restricción no encontrada"));

        restriction.setModel(dto.getModel());
        restriction.setMaxTokens(dto.getMaxTokens());
        restriction.setActive(dto.isActive());

        return toResponse(restrictionRepository.save(restriction));
    }

    @Override
    public void toggleStatus(Long id) {
        Restriction restriction = restrictionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restricción no encontrada"));
        restriction.setActive(!restriction.isActive());
        restrictionRepository.save(restriction);
    }

    private RestrictionResponseDTO toResponse(Restriction restriction) {
        return RestrictionResponseDTO.builder()
                .id(restriction.getId())
                .model(restriction.getModel())
                .maxTokens(restriction.getMaxTokens())
                .active(restriction.isActive())
                .companyName(restriction.getCompany().getName())
                .build();
    }
}