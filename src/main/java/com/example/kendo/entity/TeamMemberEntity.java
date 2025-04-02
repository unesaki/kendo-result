package com.example.kendo.entity;

import lombok.Data;

@Data
public class TeamMemberEntity {
    private Long teamId;
    private Long userId;
    private int status;      
    private String joinedAt;
}