package com.example.kendo.entity;

import lombok.Data;

@Data
public class TeamTemplatePlayerEntity {
    private Long id;
    private Long templateId;
    private String position;
    private String playerName;
}
