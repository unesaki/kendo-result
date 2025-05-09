package com.example.kendo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class TeamTemplateMemberDto {

	@NotBlank(message = "{E_VAL_MSG_0001}")
    private String position;

    @Size(max = 10, message = "{E_VAL_MSG_0006}")
    private String playerName;
}
