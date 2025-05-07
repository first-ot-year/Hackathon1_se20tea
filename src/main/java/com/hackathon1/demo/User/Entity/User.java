package com.hackathon1.demo.User.Entity;


import com.hackathon1.demo.company.domain.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private UserRole role;// e.g., "ROLE_USER", "ROLE_COMPANY_ADMIN"

    @Column(nullable = false)
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}

