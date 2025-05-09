package com.example.kendo.service;

import com.example.kendo.requestDto.RegisterTeamTemplateRequestDto;
import com.example.kendo.responseDto.RegisterTeamTemplateResponseDto;

public interface TeamTemplateService {
	RegisterTeamTemplateResponseDto registerTeamTemplate(RegisterTeamTemplateRequestDto requestDto, Long userId);
}
