package com.hackathon1.demo.company.domain;


import com.hackathon1.demo.company.infrastructure.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company>  getAll(){
        List<Company> companies = companyRepository.findAll();
        return companies;
    }

    public Company findById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    public Company save(Company company) {
        return companyRepository.save(company);
    }

    public Company update(Long id, Company company) {
        if (companyRepository.existsById(id)) {
            company.setId(id);
            return companyRepository.save(company);
        }
        return null;
    }

    public void delete(Long id) {
        companyRepository.deleteById(id);
    }



}
