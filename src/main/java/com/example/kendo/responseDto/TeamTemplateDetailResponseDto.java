package com.example.kendo.responseDto;

import java.util.List;

import com.example.kendo.dto.TeamTemplateMemberDto;

import lombok.Data;

@Data
public class TeamTemplateDetailResponseDto {
    private Long templateId;
    private String teamName;
    private List<TeamTemplateMemberDto> members;
}
