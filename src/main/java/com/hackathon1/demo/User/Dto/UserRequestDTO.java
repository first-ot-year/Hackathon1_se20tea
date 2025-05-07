package com.hackathon1.demo.User.Dto;

import com.hackathon1.demo.User.Entity.UserRole;
import lombok.Data;

@Data
public class UserRequestDTO {
    private String name;
    private String email;
    private String password;
    private UserRole role;
    private Long companyId;
}
