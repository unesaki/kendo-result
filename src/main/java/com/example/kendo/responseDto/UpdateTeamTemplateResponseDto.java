package com.example.kendo.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateTeamTemplateResponseDto {

    private Long templateId;

    private Long updatedByUserId;

    private String message;
}
