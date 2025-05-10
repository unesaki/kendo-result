package com.example.kendo.service;

import com.example.kendo.requestDto.RegisterTeamTemplateRequestDto;
import com.example.kendo.requestDto.UpdateTeamTemplateRequestDto;
import com.example.kendo.responseDto.RegisterTeamTemplateResponseDto;
import com.example.kendo.responseDto.UpdateTeamTemplateResponseDto;

public interface TeamTemplateService {
	RegisterTeamTemplateResponseDto registerTeamTemplate(RegisterTeamTemplateRequestDto requestDto, Long userId);
	UpdateTeamTemplateResponseDto updateTeamTemplate(Long templateId, UpdateTeamTemplateRequestDto request, Long userId);

}
