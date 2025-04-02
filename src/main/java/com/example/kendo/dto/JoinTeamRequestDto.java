package com.example.kendo.dto;

import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class JoinTeamRequestDto {

    @NotNull(message = "{E001}")
    private Long userId;
}
