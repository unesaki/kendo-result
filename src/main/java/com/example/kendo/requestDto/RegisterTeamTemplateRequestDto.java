package com.example.kendo.requestDto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import com.example.kendo.dto.TeamTemplateMemberDto;

import lombok.Data;

@Data
public class RegisterTeamTemplateRequestDto {
	
	@NotBlank
	@Size(max = 20, message = "{E_VAL_MSG_0006}")
	private String teamName;
	
	@Size(min = 5, max = 5, message = "{E_VAL_MSG_0002}")
	@Valid
	private List<TeamTemplateMemberDto> members;
	
	
}
