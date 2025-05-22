package com.example.kendo.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kendo.entity.TeamMatchEntity;
import com.example.kendo.repository.TeamMatchRepository;
import com.example.kendo.requestDto.CreateTeamMatchRequestDto;
import com.example.kendo.responseDto.CreateTeamMatchResponseDto;
import com.example.kendo.service.TeamMatchService;

@Service
public class TeamMatchServiceImpl implements TeamMatchService {

    @Autowired
    private TeamMatchRepository teamMatchRepository;

    @Override
    public CreateTeamMatchResponseDto createTeamMatch(CreateTeamMatchRequestDto requestDto) {
        TeamMatchEntity entity = new TeamMatchEntity();
        entity.setTournamentId(requestDto.getTournamentId());
        entity.setRedTeamId(requestDto.getRedTeamId());
        entity.setWhiteTeamId(requestDto.getWhiteTeamId());
        entity.setRedTeamName(requestDto.getRedTeamName());
        entity.setWhiteTeamName(requestDto.getWhiteTeamName());
        entity.setRedTeamScore(0); // 仮スコア
        entity.setWhiteTeamScore(0);
        entity.setMatchOrder(0); // 任意
        entity.setMatchDate(requestDto.getMatchDate() != null ? requestDto.getMatchDate() : LocalDateTime.now());
        entity.setCreatedAt(LocalDateTime.now());

        teamMatchRepository.insertTeamMatch(entity);

        return new CreateTeamMatchResponseDto(entity.getId(), "団体戦結果を登録しました");
    }
}
