package com.hackathon1.demo.company.infrastructure;

import com.hackathon1.demo.company.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
