package com.hackathon1.demo.UserLimit.infrastructure;

import com.hackathon1.demo.UserLimit.domain.UserLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserLimitRepository extends JpaRepository<UserLimit, Long> {


}
