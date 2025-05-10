package com.example.kendo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.kendo.entity.TeamTemplateEntity;
import com.example.kendo.entity.TeamTemplatePlayerEntity;

@Mapper
public interface TeamTemplateRepository {

    void insertTeamTemplate(TeamTemplateEntity entity);
    void insertTeamTemplatePlayers(List<TeamTemplatePlayerEntity> players);
    
    boolean existsById(@Param("templateId") Long templateId);
    void updateTeamTemplate(TeamTemplateEntity entity);
    void deleteTeamTemplatePlayers(@Param("templateId") Long templateId);
    void deleteTeamTemplate(@Param("templateId") Long templateId);
}
