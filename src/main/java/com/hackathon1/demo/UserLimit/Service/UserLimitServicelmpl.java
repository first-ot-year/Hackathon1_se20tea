package com.hackathon1.demo.UserLimit.Service;

import com.hackathon1.demo.User.Service.UserRepository;
import com.hackathon1.demo.User.entity.User;
import com.hackathon1.demo.UserLimit.Dto.UserLimitRequestDTO;
import com.hackathon1.demo.UserLimit.Dto.UserLimitResponseDTO;
import com.hackathon1.demo.UserLimit.Repository.UserLimitRepository;
import com.hackathon1.demo.UserLimit.entity.UserLimit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserLimitServiceImpl implements UserLimitService {

    private final UserLimitRepository userLimitRepository;
    private final UserRepository userRepository;

    @Override
    public UserLimitResponseDTO create(UserLimitRequestDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        UserLimit limit = UserLimit.builder()
                .dailyLimit(dto.getDailyLimit())
                .monthlyLimit(dto.getMonthlyLimit())
                .tokensLimit(dto.getTokensLimit())
                .user(user)
                .build();

        return toResponse(userLimitRepository.save(limit));
    }

    @Override
    public List<UserLimitResponseDTO> getAll() {
        return userLimitRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserLimitResponseDTO getByUserId(Long userId) {
        return userLimitRepository.findByUserId(userId)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Límite no encontrado para este usuario"));
    }

    private UserLimitResponseDTO toResponse(UserLimit limit) {
        return UserLimitResponseDTO.builder()
                .id(limit.getId())
                .dailyLimit(limit.getDailyLimit())
                .monthlyLimit(limit.getMonthlyLimit())
                .tokensLimit(limit.getTokensLimit())
                .userEmail(limit.getUser().getEmail())
                .build();
    }
}
