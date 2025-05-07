package com.hackathon1.demo.Company.Dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


@Data
@Builder
public class CompanyResponseDTO {
    private Long id;
    private String name;
    private String ruc;
    private LocalDate affiliationDate;
    private boolean active;
}
