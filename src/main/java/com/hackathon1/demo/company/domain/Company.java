package com.hackathon1.demo.company.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CompanyEntity") //JAVA
public class Company {

    @Id
    @SequenceGenerator(
            name = "company_sequence",
            sequenceName = "company_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", nullable = false, length = 4)
    private Long id;

    @Column(name = "ruc", nullable = false, length = 260, unique = true)
    private String ruc;

    @Column(name = "name", nullable = false, length = 4000)
    private String name;

    @Column(name = "registration_date", nullable = false, length = 4000)
    private LocalDate registration_date;

    @Column(name = "estado", nullable = false, length = 1)
    private String state;


    // @OneToMany(mappedBy = "company")
    // private List<User> users;

}
