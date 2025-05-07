package com.hackathon1.demo.Request.Controller;

import com.hackathon1.demo.Request.Dto.RequestRequestDTO;
import com.hackathon1.demo.Request.Dto.RequestResponseDTO;
import com.hackathon1.demo.Request.Service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/requests")
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;

    @PostMapping
    public ResponseEntity<RequestResponseDTO> create(@RequestBody RequestRequestDTO dto) {
        return ResponseEntity.ok(requestService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<RequestResponseDTO>> getAll() {
        return ResponseEntity.ok(requestService.getAll());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RequestResponseDTO>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(requestService.getByUser(userId));
    }
}