package com.example.kendo.requestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginUserRequestDto {

    @NotBlank(message = "{E001}")
    @Email(message = "{E002}")
    private String email;

    @NotBlank(message = "{E001}")
    private String password;
}
