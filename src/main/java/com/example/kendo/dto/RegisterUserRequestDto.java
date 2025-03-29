package com.example.kendo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class RegisterUserRequestDto {

    @NotBlank(message = "{E001}")
    private String username;

    @NotBlank(message = "{E001}")
    @Email(message = "{E002}")
    private String email;

    @NotBlank(message = "{E001}")
    private String password;
}

