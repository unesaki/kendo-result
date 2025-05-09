package com.example.kendo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kendo.entity.TeamTemplateEntity;
import com.example.kendo.entity.TeamTemplatePlayerEntity;
import com.example.kendo.repository.TeamTemplateRepository;
import com.example.kendo.requestDto.RegisterTeamTemplateRequestDto;
import com.example.kendo.responseDto.RegisterTeamTemplateResponseDto;
import com.example.kendo.service.TeamTemplateService;

@Service
public class TeamTemplateServiceImpl implements TeamTemplateService{
	
	@Autowired
    private TeamTemplateRepository teamTemplateRepository;

    public RegisterTeamTemplateResponseDto registerTeamTemplate(RegisterTeamTemplateRequestDto request, Long userId) {
        TeamTemplateEntity templateEntity = new TeamTemplateEntity();
        templateEntity.setTeamName(request.getTeamName());

        teamTemplateRepository.insertTeamTemplate(templateEntity); // IDがセットされる

        List<TeamTemplatePlayerEntity> players = request.getMembers().stream()
            .map(dto -> {
                TeamTemplatePlayerEntity entity = new TeamTemplatePlayerEntity();
                entity.setTemplateId(templateEntity.getId());
                entity.setPosition(dto.getPosition());
                entity.setPlayerName(dto.getPlayerName());
                return entity;
            }).collect(Collectors.toList());

        teamTemplateRepository.insertTeamTemplatePlayers(players);

        return new RegisterTeamTemplateResponseDto(templateEntity.getId(), userId, "テンプレートを登録しました。");
    }
}
