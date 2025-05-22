package com.example.kendo.service;

import com.example.kendo.requestDto.CreateTeamMatchRequestDto;
import com.example.kendo.responseDto.CreateTeamMatchResponseDto;

public interface TeamMatchService {
    CreateTeamMatchResponseDto createTeamMatch(CreateTeamMatchRequestDto requestDto);
}
