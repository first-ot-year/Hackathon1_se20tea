package com.hackathon1.demo.UserLimit.entity;

import com.hackathon1.demo.User.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_limits")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLimit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int dailyLimit;
    private int monthlyLimit;
    private int tokensLimit;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;


}
