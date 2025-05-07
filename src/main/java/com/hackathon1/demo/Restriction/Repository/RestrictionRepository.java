package com.hackathon1.demo.Restriction.Repository;

import com.hackathon1.demo.Restriction.entity.Restriction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestrictionRepository extends JpaRepository<Restriction, Long> {
    List<Restriction> findByCompanyId(Long companyId);
}