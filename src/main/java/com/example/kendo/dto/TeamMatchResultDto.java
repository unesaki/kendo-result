package com.example.kendo.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class TeamMatchResultDto {

    private String redPlayerName;

    private String whitePlayerName;

    @Size(max = 2, message = "E_VAL_MSG_0006")
    private List<String> redPoints;

    @Size(max = 2, message = "E_VAL_MSG_0006")
    private List<String> whitePoints;

    private Boolean redWinDefault = false;

    private Boolean whiteWinDefault = false;

    private Boolean draw = false;

    @NotBlank(message = "E_VAL_MSG_0001")
    private String position;
}

