package com.hackathon1.demo.User.Dto;

import com.hackathon1.demo.User.Entity.UserRole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private UserRole role;
    private boolean active;
    private String companyName;
}
