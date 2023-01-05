package com.ty.blog.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotNull
    private String firstName;
    private String middleName;
    @NotNull
    private String lastName;
    @NotBlank
    private String mobile;
    @NotBlank
    private String email;
    @NotNull
    private String passwordHash;
    private LocalDateTime registeredAt;
    private LocalDateTime lastLogin;
    private String intro;
    private String profile;

}