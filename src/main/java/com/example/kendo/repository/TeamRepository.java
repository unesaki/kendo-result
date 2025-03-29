package com.example.kendo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.kendo.entity.TeamEntity;

@Mapper
public interface TeamRepository {

    /**
     * チームを新規作成します。
     * @param entity 登録するチーム情報
     */
    void insert(TeamEntity entity);
}
