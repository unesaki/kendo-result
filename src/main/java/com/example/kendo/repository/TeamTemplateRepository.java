package com.example.kendo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.kendo.entity.TeamTemplateEntity;
import com.example.kendo.entity.TeamTemplatePlayerEntity;

@Mapper
public interface TeamTemplateRepository {

    void insertTeamTemplate(TeamTemplateEntity entity);
    void insertTeamTemplatePlayers(List<TeamTemplatePlayerEntity> players);
    
    boolean existsById(Long templateId);
    void updateTeamTemplate(TeamTemplateEntity entity);
    void deleteTeamTemplatePlayers(Long templateId);
}
