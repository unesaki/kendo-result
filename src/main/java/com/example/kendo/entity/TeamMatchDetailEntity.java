package com.example.kendo.entity;

import lombok.Data;

@Data
public class TeamMatchDetailEntity {
    private Long id;
    private Long teamMatchId;
    private String redPlayerName;
    private String whitePlayerName;
    private String redPoints;
    private String whitePoints;
    private Boolean redWinDefault;
    private Boolean whiteWinDefault;
    private Boolean draw;
    private String position;
}

