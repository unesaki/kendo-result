package com.example.kendo.requestDto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.example.kendo.dto.TeamTemplateMemberDto;

import lombok.Data;

@Data
public class UpdateTeamTemplateRequestDto {

    @NotBlank(message = "{E_VAL_MSG_0001}")
    @Size(max = 20, message = "{E_VAL_MSG_0006}")
    private String teamName;

    @NotNull(message = "{E_VAL_MSG_0002}")
    @Size(min = 5, max = 5, message = "{E_VAL_MSG_0002}")
    private List<TeamTemplateMemberDto> members;
}
