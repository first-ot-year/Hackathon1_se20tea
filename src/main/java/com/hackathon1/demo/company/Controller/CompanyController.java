package com.hackathon1.demo.company.Controller;


import com.hackathon1.demo.company.Dto.CompanyRequestDTO;
import com.hackathon1.demo.company.Dto.CompanyResponseDTO;
import com.hackathon1.demo.company.Service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController() {
        companyService = null;
    }

    @PostMapping
    public ResponseEntity<CompanyResponseDTO> create(@RequestBody CompanyRequestDTO dto) {
        return ResponseEntity.ok(companyService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<CompanyResponseDTO>> getAll() {
        return ResponseEntity.ok(companyService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyResponseDTO> update(@PathVariable Long id, @RequestBody CompanyRequestDTO dto) {
        return ResponseEntity.ok(companyService.update(id, dto));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> toggleStatus(@PathVariable Long id) {
        companyService.toggleStatus(id);
        return ResponseEntity.ok().build();
    }

}
