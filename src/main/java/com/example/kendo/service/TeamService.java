package com.example.kendo.service;

import java.util.List;

import com.example.kendo.dto.TeamDetailResponseDto;
import com.example.kendo.dto.TeamListResponseDto;
import com.example.kendo.requestDto.AcceptTeamRequestDto;
import com.example.kendo.requestDto.CreateTeamRequestDto;
import com.example.kendo.requestDto.JoinTeamRequestDto;

public interface TeamService {

    /**
     * チームを新規作成します。
     * @param requestDto 作成リクエスト
     */
    void createTeam(CreateTeamRequestDto requestDto);
    List<TeamListResponseDto> getAllTeams();
    TeamDetailResponseDto getTeamDetail(Long id);
    void joinTeam(Long teamId, JoinTeamRequestDto requestDto);
    void acceptTeamRequest(Long teamId, AcceptTeamRequestDto requestDto);

}

