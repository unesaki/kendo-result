package com.example.kendo.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTeamMatchResponseDto {
    private Long teamMatchId;
    private String message;
}