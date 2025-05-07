package com.hackathon1.demo.Company.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "companies")
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 260, unique = true)
    private String name;
    @Column(name = "ruc", nullable = false, length = 4000)
    private String ruc;
    @Column(name = "affiltionData", nullable = false, length = 4000)
    private LocalDate affiliationDate;
    @Column(name = "state", nullable = false, length = 1)
    private boolean active;

}
