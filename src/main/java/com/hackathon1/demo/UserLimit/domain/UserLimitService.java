package com.hackathon1.demo.UserLimit.domain;

import com.hackathon1.demo.UserLimit.domain.UserLimit;
import com.hackathon1.demo.UserLimit.dto.UserLimitDTO;
import com.hackathon1.demo.UserLimit.repository.UserLimitRepository;
import com.hackathon1.demo.UserLimit.repository.UserRepository;
import com.hackathon1.demo.UserLimit.domain.User;
import com.hackathon1.demo.UserLimit.domain.ModelType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Optional;

@Service
public class UserLimitService {

    @Autowired
    private UserLimitRepository userLimitRepository;

    @Autowired
    private UserRepository userRepository;

    public UserLimit createUserLimit(UserLimitDTO userLimitDTO, Long userId) {

        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado");
        }

        UserLimit userLimit = new UserLimit();
        userLimit.setModelType(userLimitDTO.getModelType());
        userLimit.setMaxRequests(userLimitDTO.getMaxRequests());
        userLimit.setMaxTokens(userLimitDTO.getMaxTokens());
        userLimit.setWindowDuration(userLimitDTO.getWindowDuration());
        userLimit.setUser(user.get());

        return userLimitRepository.save(userLimit);
    }
    public UserLimit updateUserLimit(Long userLimitId, UserLimitDTO userLimitDTO) {
        // Buscar el UserLimit por ID
        Optional<UserLimit> existingLimit = userLimitRepository.findById(userLimitId);
        if (existingLimit.isEmpty()) {
            throw new RuntimeException("Límite de usuario no encontrado");
        }
        UserLimit userLimit = existingLimit.get();
        userLimit.setModelType(userLimitDTO.getModelType());
        userLimit.setMaxRequests(userLimitDTO.getMaxRequests());
        userLimit.setMaxTokens(userLimitDTO.getMaxTokens());
        userLimit.setWindowDuration(userLimitDTO.getWindowDuration());

        return userLimitRepository.save(userLimit);
    }


    public UserLimit getUserLimit(Long userLimitId) {
        Optional<UserLimit> userLimit = userLimitRepository.findById(userLimitId);
        if (userLimit.isEmpty()) {
            throw new RuntimeException("Límite de usuario no encontrado");
        }
        return userLimit.get();
    }

    public boolean isLimitExceeded(User user, ModelType modelType) {

        UserLimit userLimit = userLimitRepository.findByUserAndModelType(user, modelType);

        if (userLimit == null) {
            throw new RuntimeException("No se encontró un límite para el modelo");
        }



        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime windowStart = now.minus(userLimit.getWindowDuration());

        long requestsInWindow = getRequestsMadeInWindow(user, modelType, windowStart);

        if (requestsInWindow >= userLimit.getMaxRequests()) {
            return true;
        }

        return false;
    }

    private long getRequestsMadeInWindow(User user, ModelType modelType, ZonedDateTime windowStart) {

        return userLimitRepository.countRequestsByUserAndModelTypeAndCreatedAtAfter(user, modelType, windowStart);
    }
}