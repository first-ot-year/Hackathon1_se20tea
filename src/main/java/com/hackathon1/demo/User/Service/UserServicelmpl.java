package com.hackathon1.demo.User.Service;


import com.hackathon1.demo.User.Dto.UserRequestDTO;
import com.hackathon1.demo.User.Dto.UserResponseDTO;
import com.hackathon1.demo.User.Entity.User;
import com.hackathon1.demo.User.infrastructure.UserRepository;
import com.hackathon1.demo.company.domain.Company;
import com.hackathon1.demo.company.infrastructure.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServicelmpl implements UserService{
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    @Override
    public UserResponseDTO create(UserRequestDTO dto) {
        Company company = companyRepository.findById(dto.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));

        User user = User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .role(dto.getRole())
                .active(true)
                .company(company)
                .build();

        return toResponse(userRepository.save(user));
    }

    @Override
    public List<UserResponseDTO> getAll() {
        return userRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO getById(Long id) {
        return userRepository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public UserResponseDTO update(Long id, UserRequestDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());

        return toResponse(userRepository.save(user));
    }

    @Override
    public void toggleStatus(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        user.setActive(!user.isActive());
        userRepository.save(user);
    }

    private UserResponseDTO toResponse(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .active(user.isActive())
                .companyName(user.getCompany().getName())
                .build();
    }
}
