package com.example.kendo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.kendo.entity.TeamMemberEntity;

@Mapper
public interface TeamMemberRepository {

    void insertPending(TeamMemberEntity entity);
}