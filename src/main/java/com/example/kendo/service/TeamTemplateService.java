package com.example.kendo.service;

import java.util.List;

import com.example.kendo.dto.TeamTemplateListDto;
import com.example.kendo.requestDto.RegisterTeamTemplateRequestDto;
import com.example.kendo.requestDto.UpdateTeamTemplateRequestDto;
import com.example.kendo.responseDto.DeleteTeamTemplateResponseDto;
import com.example.kendo.responseDto.RegisterTeamTemplateResponseDto;
import com.example.kendo.responseDto.TeamTemplateDetailResponseDto;
import com.example.kendo.responseDto.UpdateTeamTemplateResponseDto;

public interface TeamTemplateService {
	RegisterTeamTemplateResponseDto registerTeamTemplate(RegisterTeamTemplateRequestDto requestDto, Long userId);
	UpdateTeamTemplateResponseDto updateTeamTemplate(Long templateId, UpdateTeamTemplateRequestDto request, Long userId);
	DeleteTeamTemplateResponseDto deleteTeamTemplate(Long templateId, Long userId);
	List<TeamTemplateListDto> getTeamTemplateList();
	TeamTemplateDetailResponseDto getTeamTemplateDetail(Long templateId);
}
