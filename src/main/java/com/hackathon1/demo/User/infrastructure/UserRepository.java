package com.hackathon1.demo.User.infrastructure;

import com.hackathon1.demo.User.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByCompanyId(Long companyId);
}
