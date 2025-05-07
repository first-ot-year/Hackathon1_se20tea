package com.hackathon1.demo.company.Repository;

import com.hackathon1.demo.company.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
