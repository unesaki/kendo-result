package com.example.kendo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.kendo.entity.TeamMemberEntity;
import com.example.kendo.entity.TeamTemplateEntity;
import com.example.kendo.entity.TeamTemplatePlayerEntity;

@Mapper
public interface TeamMemberRepository {

    void insertPending(TeamMemberEntity entity);
    void updateStatusToApproved(Long teamId, Long userId);
    boolean existsById(Long templateId);
    void updateTeamTemplate(TeamTemplateEntity entity);
    void deleteTeamTemplatePlayers(Long templateId);
    void insertTeamTemplatePlayers(List<TeamTemplatePlayerEntity> players);
}