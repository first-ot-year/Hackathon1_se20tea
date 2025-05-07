package com.hackathon1.demo.Request.Service;

import com.hackathon1.demo.Request.Dto.RequestRequestDTO;
import com.hackathon1.demo.Request.Dto.RequestResponseDTO;
import com.hackathon1.demo.Request.Repository.RequestRepository;
import com.hackathon1.demo.Request.entity.Request;
import com.hackathon1.demo.User.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;
    private final UserRepository userRepository;

    @Override
    public RequestResponseDTO create(RequestRequestDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Request request = Request.builder()
                .model(dto.getModel())
                .prompt(dto.getPrompt())
                .tokensUsed(dto.getTokensUsed())
                .createdAt(LocalDateTime.now())
                .user(user)
                .build();

        return toResponse(requestRepository.save(request));
    }

    @Override
    public List<RequestResponseDTO> getAll() {
        return requestRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<RequestResponseDTO> getByUser(Long userId) {
        return requestRepository.findByUserId(userId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private RequestResponseDTO toResponse(Request r) {
        return RequestResponseDTO.builder()
                .id(r.getId())
                .model(r.getModel())
                .prompt(r.getPrompt())
                .tokensUsed(r.getTokensUsed())
                .createdAt(r.getCreatedAt())
                .userEmail(r.getUser().getEmail())
                .build();
    }
}