package com.example.kendo.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.kendo.dto.RegisterUserRequestDto;
import com.example.kendo.entity.UserEntity;
import com.example.kendo.repository.UserRepository;
import com.example.kendo.service.UserService;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void register(RegisterUserRequestDto requestDto) {
        // メールアドレスの重複チェック
        if (userRepository.countByEmail(requestDto.getEmail()) > 0) {
            throw new IllegalArgumentException("メールアドレスは既に使用されています。");
        }

        // UserEntityへの詰め替え
        UserEntity entity = new UserEntity();
        entity.setUsername(requestDto.getUsername());
        entity.setEmail(requestDto.getEmail());
        entity.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        entity.setCreatedAt(LocalDateTime.now());

        // 永続化
        userRepository.insert(entity);
    }
}
