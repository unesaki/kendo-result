package com.example.kendo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.kendo.entity.UserEntity;

@Mapper
public interface UserRepository {

    /**
     * 指定されたメールアドレスを持つユーザーの件数を取得します。
     * @param email メールアドレス
     * @return 件数
     */
    int countByEmail(@Param("email") String email);

    /**
     * ユーザー情報を登録します。
     * @param entity 登録するユーザー情報
     */
    void insert(UserEntity entity);
    
    /**
     * メールアドレスでユーザーを検索します
     * @param email メールアドレス
     * @return 該当ユーザー（なければnull）
     */
    UserEntity findByEmail(@Param("email") String email);
    UserEntity findById(Long id);
}
