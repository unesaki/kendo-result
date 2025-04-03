package com.example.kendo.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kendo.dto.AcceptTeamRequestDto;
import com.example.kendo.dto.CreateTeamRequestDto;
import com.example.kendo.dto.JoinTeamRequestDto;
import com.example.kendo.dto.TeamDetailResponseDto;
import com.example.kendo.dto.TeamListResponseDto;
import com.example.kendo.entity.TeamEntity;
import com.example.kendo.entity.TeamMemberEntity;
import com.example.kendo.repository.TeamMemberRepository;
import com.example.kendo.repository.TeamRepository;
import com.example.kendo.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamMemberRepository teamMemberRepository;
    
    @Override
    public void createTeam(CreateTeamRequestDto requestDto) {
        TeamEntity entity = new TeamEntity();
        entity.setName(requestDto.getName());

        // created_at を現在時刻で設定（フォーマットはDBに合わせて）
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        entity.setCreatedAt(now);

        teamRepository.insert(entity);
    }
    
    @Override
    public List<TeamListResponseDto> getAllTeams() {
        List<TeamEntity> teamList = teamRepository.findAll();
        return teamList.stream().map(entity -> {
            TeamListResponseDto dto = new TeamListResponseDto();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setCreatedAt(entity.getCreatedAt());
            return dto;
        }).collect(Collectors.toList());
    }
    
    
    @Override
    public TeamDetailResponseDto getTeamDetail(Long id) {
        TeamEntity entity = teamRepository.findById(id);
        if (entity == null) {
            throw new NoSuchElementException("指定されたチームが存在しません。");
        }

        TeamDetailResponseDto dto = new TeamDetailResponseDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }
    
    @Override
    public void joinTeam(Long teamId, JoinTeamRequestDto requestDto) {
        TeamMemberEntity entity = new TeamMemberEntity();
        entity.setTeamId(teamId);
        entity.setUserId(requestDto.getUserId());
        entity.setStatus(0);
        entity.setJoinedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        teamMemberRepository.insertPending(entity);
    }
    
    @Override
    public void acceptTeamRequest(Long teamId, AcceptTeamRequestDto requestDto) {
        teamMemberRepository.updateStatusToApproved(teamId, requestDto.getUserId());
    }


}