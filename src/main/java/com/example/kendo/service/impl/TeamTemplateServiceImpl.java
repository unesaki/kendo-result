package com.example.kendo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kendo.dto.TeamTemplateListDto;
import com.example.kendo.entity.TeamTemplateEntity;
import com.example.kendo.entity.TeamTemplatePlayerEntity;
import com.example.kendo.exception.BusinessException;
import com.example.kendo.repository.TeamTemplateRepository;
import com.example.kendo.requestDto.RegisterTeamTemplateRequestDto;
import com.example.kendo.requestDto.UpdateTeamTemplateRequestDto;
import com.example.kendo.responseDto.DeleteTeamTemplateResponseDto;
import com.example.kendo.responseDto.RegisterTeamTemplateResponseDto;
import com.example.kendo.responseDto.UpdateTeamTemplateResponseDto;
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
    
    @Override
    public UpdateTeamTemplateResponseDto updateTeamTemplate(Long templateId, UpdateTeamTemplateRequestDto request, Long userId) {
        boolean exists = teamTemplateRepository.existsById(templateId);
        if (!exists) {
            throw new BusinessException("E_DB_MSG_0001", "templateId");
        }

        // ヘッダ更新
        TeamTemplateEntity entity = new TeamTemplateEntity();
        entity.setId(templateId);
        entity.setTeamName(request.getTeamName());
        teamTemplateRepository.updateTeamTemplate(entity);

        // 明細削除・登録
        teamTemplateRepository.deleteTeamTemplatePlayers(templateId);

        List<TeamTemplatePlayerEntity> players = request.getMembers().stream().map(dto -> {
            TeamTemplatePlayerEntity player = new TeamTemplatePlayerEntity();
            player.setTemplateId(templateId);
            player.setPosition(dto.getPosition());
            player.setPlayerName(dto.getPlayerName());
            return player;
        }).collect(Collectors.toList());

        teamTemplateRepository.insertTeamTemplatePlayers(players);

        return new UpdateTeamTemplateResponseDto(templateId, userId, "テンプレートを更新しました");
    }
    
    @Override
    public DeleteTeamTemplateResponseDto deleteTeamTemplate(Long templateId, Long userId) {
        if (!teamTemplateRepository.existsById(templateId)) {
            throw new BusinessException("E_DB_MSG_0001", "templateId");
        }

        teamTemplateRepository.deleteTeamTemplatePlayers(templateId);
        teamTemplateRepository.deleteTeamTemplate(templateId);

        return new DeleteTeamTemplateResponseDto(templateId, userId, "テンプレートを削除しました。");
    }
    
    @Override
    public List<TeamTemplateListDto> getTeamTemplateList() {
        return teamTemplateRepository.selectTeamTemplateList();
    }
}
