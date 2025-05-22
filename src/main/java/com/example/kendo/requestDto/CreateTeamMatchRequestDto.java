package com.example.kendo.requestDto;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.kendo.dto.TeamMatchResultDto;

import lombok.Data;

@Data
public class CreateTeamMatchRequestDto {

    @NotNull(message = "{E_VAL_MSG_0001}")
    private Long tournamentId;

    @NotNull(message = "{E_VAL_MSG_0001}")
    private Long redTeamId;

    @NotNull(message = "{E_VAL_MSG_0001}")
    private Long WhiteTeamId;

    @NotBlank(message = "{E_VAL_MSG_0001}")
    @Size(max = 100, message = "{E_VAL_MSG_0003}")
    private String redTeamName;

    @NotBlank(message = "{E_VAL_MSG_0001}")
    @Size(max = 100, message = "{E_VAL_MSG_0003}")
    private String whiteTeamName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime matchDate;

    @NotNull(message = "{E_VAL_MSG_0001}")
    @Size(min = 5, max = 5, message = "{E_VAL_MSG_0002}")
    private List<TeamMatchResultDto> matchResults;
}


