package com.example.kendo.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kendo.dto.CreateTeamRequestDto;
import com.example.kendo.dto.CreateTeamResponseDto;
import com.example.kendo.dto.JoinTeamRequestDto;
import com.example.kendo.dto.JoinTeamResponseDto;
import com.example.kendo.dto.TeamDetailResponseDto;
import com.example.kendo.dto.TeamListResponseDto;
import com.example.kendo.service.TeamService;

@RestController
@RequestMapping("/api")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping("/teams")
    public ResponseEntity<CreateTeamResponseDto> createTeam(
            @RequestBody @Valid CreateTeamRequestDto requestDto) {
        
        teamService.createTeam(requestDto);
        return ResponseEntity.status(201)
                .body(new CreateTeamResponseDto("チームを作成しました"));
    }
    
    @GetMapping("/teams")
    public ResponseEntity<List<TeamListResponseDto>> getTeamList() {
        List<TeamListResponseDto> list = teamService.getAllTeams();
        return ResponseEntity.ok(list);
    }
    
    @GetMapping("/teams/{teamId}")
    public ResponseEntity<TeamDetailResponseDto> getTeamDetail(@PathVariable Long teamId) {
        TeamDetailResponseDto dto = teamService.getTeamDetail(teamId);
        return ResponseEntity.ok(dto);
    }
    
    @PostMapping("/teams/{teamId}/join")
    public ResponseEntity<JoinTeamResponseDto> joinTeam(
            @PathVariable Long teamId,
            @RequestBody @Valid JoinTeamRequestDto requestDto) {
        
        teamService.joinTeam(teamId, requestDto);
        return ResponseEntity.status(201).body(new JoinTeamResponseDto("参加リクエストを送信しました"));
    }


}