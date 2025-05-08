package com.example.kendo.entity;

import lombok.Data;

@Data
public class TeamMatchDetailEntity {
    private Long id;
    private Long teamMatchId;
    private String redPlayerName;
    private String whitePlayerName;
    private String result; // "赤勝ち" / "白勝ち" / "引き分け"
    private String position; // "先鋒", "次鋒", "中堅", "副将", "大将"
}
