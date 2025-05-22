package com.example.kendo.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TeamMatchEntity {
    private Long id;
    private Long tournamentId;
    private Long redTeamId;
    private Long whiteTeamId;
    private String redTeamName;
    private String whiteTeamName;
    private int redTeamScore;
    private int whiteTeamScore;
    private Integer matchOrder;
    private LocalDateTime matchDate;
    private LocalDateTime createdAt;
}
