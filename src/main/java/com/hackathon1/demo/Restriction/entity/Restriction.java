package com.hackathon1.demo.Restriction.entity;

import com.hackathon1.demo.Company.entity.Company;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "restrictions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restriction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model; // ej. gpt-3.5, gpt-4
    private int maxTokens;
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
