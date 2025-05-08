package com.example.kendo.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TeamMatchEntity {
    private Long id;
    private Long tournamentId;
    private String redTeamName;
    private String whiteTeamName;
    private LocalDateTime matchDate;
}
