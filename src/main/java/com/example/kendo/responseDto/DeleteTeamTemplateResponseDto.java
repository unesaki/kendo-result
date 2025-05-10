package com.example.kendo.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteTeamTemplateResponseDto {

    private Long templateId;

    private Long deletedByUserId;

    private String message;
}
