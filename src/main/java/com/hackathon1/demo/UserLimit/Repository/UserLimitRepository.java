package com.hackathon1.demo.UserLimit.Repository;

 import com.hackathon1.demo.UserLimit.entity.UserLimit;
 import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLimitRepository extends JpaRepository<UserLimit, Long> {
    // Custom query methods can be defined here if needed
    // For example, to find a UserLimit by userId:
    // Optional<UserLimit> findByUserId(Long userId);
    Optional<UserLimit> findByUserId(Long userId);
}
