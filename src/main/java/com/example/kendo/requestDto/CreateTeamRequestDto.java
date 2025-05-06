package com.example.kendo.requestDto;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CreateTeamRequestDto {

    @NotBlank(message = "{E001}")
    private String name;
}
