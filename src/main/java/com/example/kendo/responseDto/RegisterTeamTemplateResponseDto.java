package com.example.kendo.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterTeamTemplateResponseDto {
    private Long templateId;
    private Long createdByUserId;
    private String message;
}
