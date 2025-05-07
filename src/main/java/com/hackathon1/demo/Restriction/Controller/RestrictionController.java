package com.hackathon1.demo.Restriction.Controller;

import com.hackathon1.demo.Restriction.Dto.RestrictionRequestDTO;
import com.hackathon1.demo.Restriction.Dto.RestrictionResponseDTO;
import com.hackathon1.demo.Restriction.Service.RestrictionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/restrictions")
@RequiredArgsConstructor
public class RestrictionController {

    private final RestrictionService restrictionService;

    @PostMapping
    public ResponseEntity<RestrictionResponseDTO> create(@RequestBody RestrictionRequestDTO dto) {
        return ResponseEntity.ok(restrictionService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<RestrictionResponseDTO>> getAll() {
        return ResponseEntity.ok(restrictionService.getAll());
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<RestrictionResponseDTO>> getByCompany(@PathVariable Long companyId) {
        return ResponseEntity.ok(restrictionService.getByCompany(companyId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestrictionResponseDTO> update(@PathVariable Long id, @RequestBody RestrictionRequestDTO dto) {
        return ResponseEntity.ok(restrictionService.update(id, dto));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> toggleStatus(@PathVariable Long id) {
        restrictionService.toggleStatus(id);
        return ResponseEntity.ok().build();
    }
}