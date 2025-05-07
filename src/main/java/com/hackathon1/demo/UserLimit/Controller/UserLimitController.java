package com.hackathon1.demo.UserLimit.Controller;

import com.hackathon1.demo.UserLimit.Dto.UserLimitRequestDTO;
import com.hackathon1.demo.UserLimit.Dto.UserLimitResponseDTO;
import com.hackathon1.demo.UserLimit.Service.UserLimitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UserLimitController {

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/company/limits")
    @RequiredArgsConstructor
    public class UserLimitController {

        private final UserLimitService userLimitService;

        @PostMapping
        public ResponseEntity<UserLimitResponseDTO> create(@RequestBody UserLimitRequestDTO dto) {
            return ResponseEntity.ok(userLimitService.create(dto));
        }

        @GetMapping
        public ResponseEntity<List<UserLimitResponseDTO>> getAll() {
            return ResponseEntity.ok(userLimitService.getAll());
        }

        @GetMapping("/user/{userId}")
        public ResponseEntity<UserLimitResponseDTO> getByUser(@PathVariable Long userId) {
            return ResponseEntity.ok(userLimitService.getByUserId(userId));
        }
    }
}
