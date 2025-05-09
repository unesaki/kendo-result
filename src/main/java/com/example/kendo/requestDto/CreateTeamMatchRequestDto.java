package com.example.kendo.requestDto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CreateTeamMatchRequestDto {
    private Long tournamentId;
    private String redTeamName;
    private String whiteTeamName;
    private LocalDateTime matchDate;
}
