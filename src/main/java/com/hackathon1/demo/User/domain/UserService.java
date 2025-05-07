package com.hackathon1.demo.User.domain;

import com.hackathon1.demo.User.infrastructure.UserRepository;
import com.hackathon1.demo.Company.domain.Company;
import com.hackathon1.demo.Company.infrastructure.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final UserLimitRepository userLimitRepository;
    private final AIRequestRepository aiRequestRepository;

    public User createUser(User user, Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
        user.setCompany(company);
        return userRepository.save(user);
    }

    public List<User> getAllUsersByCompany(Long companyId) {
        return userRepository.findByCompanyId(companyId);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public User updateUser(Long id, User updatedUser) {
        User existingUser = getUserById(id);
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public UserLimit assignLimitToUser(Long userId, UserLimit limit) {
        User user = getUserById(userId);
        limit.setUser(user);
        limit.setCreatedAt(LocalDateTime.now());
        return userLimitRepository.save(limit);
    }

    public UserConsumptionDTO getUserConsumption(Long userId) {
        List<AIRequest> requests = aiRequestRepository.findByUserId(userId);

        Map<ModelType, Integer> totalTokensPerModel = new HashMap<>();
        Map<ModelType, Integer> totalRequestsPerModel = new HashMap<>();

        for (AIRequest request : requests) {
            ModelType model = request.getModelType();
            totalTokensPerModel.put(model,
                    totalTokensPerModel.getOrDefault(model, 0) + request.getTokensUsed());
            totalRequestsPerModel.put(model,
                    totalRequestsPerModel.getOrDefault(model, 0) + 1);
        }

        return new UserConsumptionDTO(userId, totalRequestsPerModel, totalTokensPerModel);
    }

}
