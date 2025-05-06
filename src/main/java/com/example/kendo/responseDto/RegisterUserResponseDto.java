package com.example.kendo.responseDto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserResponseDto {
    private Long userId;
    private String username;
    private String email;
    private LocalDateTime createdAt;
}
