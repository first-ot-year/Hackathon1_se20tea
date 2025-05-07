package com.hackathon1.demo.Request.Repository;

import com.hackathon1.demo.Request.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findByUserId(Long userId);
}