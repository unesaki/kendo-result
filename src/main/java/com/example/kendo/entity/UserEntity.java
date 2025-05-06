package com.example.kendo.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserEntity {
	private Long id;
    private String username;
    private String email;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
