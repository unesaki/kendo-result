package com.example.kendo.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kendo.dto.CreateTeamRequestDto;
import com.example.kendo.entity.TeamEntity;
import com.example.kendo.repository.TeamRepository;
import com.example.kendo.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public void createTeam(CreateTeamRequestDto requestDto) {
        TeamEntity entity = new TeamEntity();
        entity.setName(requestDto.getName());

        // created_at を現在時刻で設定（フォーマットはDBに合わせて）
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        entity.setCreatedAt(now);

        teamRepository.insert(entity);
    }
}