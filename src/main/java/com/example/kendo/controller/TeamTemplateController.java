package com.example.kendo.controller;



import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kendo.requestDto.RegisterTeamTemplateRequestDto;
import com.example.kendo.requestDto.UpdateTeamTemplateRequestDto;
import com.example.kendo.responseDto.RegisterTeamTemplateResponseDto;
import com.example.kendo.responseDto.UpdateTeamTemplateResponseDto;
import com.example.kendo.security.UserPrincipal;
import com.example.kendo.service.TeamTemplateService;

@RestController
@RequestMapping("/api")
public class TeamTemplateController {

    @Autowired
    private TeamTemplateService teamTemplateService;

    @PostMapping("/team-templates")
    public ResponseEntity<RegisterTeamTemplateResponseDto> registerTeamTemplate(
            @RequestBody @Valid RegisterTeamTemplateRequestDto request,
            @AuthenticationPrincipal UserPrincipal user) {

        RegisterTeamTemplateResponseDto response =
                teamTemplateService.registerTeamTemplate(request, user.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @PutMapping("/team-templates/{templateId}")
    public ResponseEntity<UpdateTeamTemplateResponseDto> updateTeamTemplate(
            @PathVariable Long templateId,
            @RequestBody @Valid UpdateTeamTemplateRequestDto request,
            @AuthenticationPrincipal UserPrincipal user) {

        UpdateTeamTemplateResponseDto response = teamTemplateService.updateTeamTemplate(templateId, request, user.getId());
        return ResponseEntity.ok(response);
    }
}
