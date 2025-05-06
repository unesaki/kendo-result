package com.example.kendo.requestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class LoginUserRequestDto {

    @NotBlank(message = "{E_VAL_MSG_0001}")
    @Email(message = "{E_VAL_MSG_0007}")
    @Size(max = 100, message = "{E_VAL_MSG_0006}")
    private String email;

    @NotBlank(message = "{E_VAL_MSG_0001}")
    @Size(max = 100, message = "{E_VAL_MSG_0006}")
    private String password;
}
