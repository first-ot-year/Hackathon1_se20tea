package com.hackathon1.demo.company.Service;

import com.hackathon1.demo.company.Dto.CompanyRequestDTO;
import com.hackathon1.demo.company.Dto.CompanyResponseDTO;
import com.hackathon1.demo.company.Entity.Company;
import com.hackathon1.demo.company.Repository.CompanyRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyServicelmpl implements CompanyService{

    private final CompanyRepository repository;

    public CompanyServicelmpl(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public CompanyResponseDTO create(CompanyRequestDTO dto) {
        Company entity = Company.builder()
                .name(dto.getName())
                .ruc(dto.getRuc())
                .affiliationDate(LocalDate.now())
                .active(true)
                .build();
        return toResponse(repository.save(entity));
    }

    @Override
    public List<CompanyResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyResponseDTO getById(Long id) {
        return repository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
    }

    @Override
    public CompanyResponseDTO update(Long id, CompanyRequestDTO dto) {
        Company entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));

        entity.setName(dto.getName());
        entity.setRuc(dto.getRuc());
        return toResponse(repository.save(entity));
    }

    @Override
    public void toggleStatus(Long id) {
        Company entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
        entity.setActive(!entity.isActive());
        repository.save(entity);
    }

    private CompanyResponseDTO toResponse(Company entity) {
        return CompanyResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .ruc(entity.getRuc())
                .affiliationDate(entity.getAffiliationDate())
                .active(entity.isActive())
                .build();
    }
}
