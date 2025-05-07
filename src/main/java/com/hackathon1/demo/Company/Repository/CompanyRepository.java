package com.hackathon1.demo.Company.Repository;

import com.hackathon1.demo.Company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    // Custom query methods can be added here if needed
}
