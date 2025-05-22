package com.example.kendo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.kendo.entity.TeamMatchDetailEntity;
import com.example.kendo.entity.TeamMatchEntity;

@Mapper
public interface TeamMatchRepository {
    void insertTeamMatch(TeamMatchEntity entity);
    void insertTeamMatchDetails(TeamMatchDetailEntity detail);
}
