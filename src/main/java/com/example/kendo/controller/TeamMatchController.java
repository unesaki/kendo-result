package com.example.kendo.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kendo.requestDto.CreateTeamMatchRequestDto;
import com.example.kendo.responseDto.CreateTeamMatchResponseDto;
import com.example.kendo.service.TeamMatchService;

@RestController
@RequestMapping("/api")
public class TeamMatchController {

    @Autowired
    private TeamMatchService teamMatchService;

    @PostMapping("/team-matches")
    public ResponseEntity<CreateTeamMatchResponseDto> createTeamMatch(
            @Valid @RequestBody CreateTeamMatchRequestDto requestDto) {
        CreateTeamMatchResponseDto response = teamMatchService.createTeamMatch(requestDto);
        return ResponseEntity.ok(response);
    }
}

