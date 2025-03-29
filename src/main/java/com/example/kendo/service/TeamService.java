package com.example.kendo.service;

import com.example.kendo.dto.CreateTeamRequestDto;

public interface TeamService {

    /**
     * チームを新規作成します。
     * @param requestDto 作成リクエスト
     */
    void createTeam(CreateTeamRequestDto requestDto);
}

