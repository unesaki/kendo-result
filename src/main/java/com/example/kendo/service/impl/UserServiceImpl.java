package com.example.kendo.service.impl;

import java.time.LocalDateTime;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.kendo.entity.UserEntity;
import com.example.kendo.exception.BusinessException;
import com.example.kendo.repository.UserRepository;
import com.example.kendo.requestDto.LoginUserRequestDto;
import com.example.kendo.requestDto.RegisterUserRequestDto;
import com.example.kendo.responseDto.LoginUserResponseDto;
import com.example.kendo.responseDto.LogoutUserResponseDto;
import com.example.kendo.responseDto.RegisterUserResponseDto;
import com.example.kendo.security.JwtTokenProvider;
import com.example.kendo.service.TokenBlacklistService;
import com.example.kendo.service.UserService;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    
    @Autowired
    private TokenBlacklistService tokenBlacklistService;

    @Override
    public RegisterUserResponseDto registerUser(RegisterUserRequestDto requestDto) {
        // メールアドレスの重複チェック
        if (userRepository.countByEmail(requestDto.getEmail()) > 0) {
            throw new BusinessException("E_DB_MSG_0004", "email");
        }
        
        // パスワードのハッシュ化
        String hashedPassword = passwordEncoder.encode(requestDto.getPassword());

        // UserEntityへの詰め替え
        UserEntity entity = new UserEntity();
        entity.setUsername(requestDto.getUsername());
        entity.setEmail(requestDto.getEmail());
        entity.setPassword(hashedPassword);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());

        // 登録処理
        userRepository.insert(entity);

        // レスポンスDTOに詰め替え
        RegisterUserResponseDto response = new RegisterUserResponseDto();
        response.setId(entity.getId());
        response.setUsername(entity.getUsername());
        response.setEmail(entity.getEmail());
        response.setCreatedAt(entity.getCreatedAt());

        return response;
    }
    
    @Override
    public LoginUserResponseDto loginUser(LoginUserRequestDto requestDto) {
        // メールでユーザー取得
        UserEntity user = userRepository.findByEmail(requestDto.getEmail());

        if (user == null) {
            throw new BusinessException("E_DB_MSG_0001", "email");
        }

        // パスワード照合（ハッシュ比較）
        if (!passwordEncoder.matches(requestDto.getPassword(), user.getPassword())) {
            throw new BusinessException("E_AUTH_MSG_0001", "email");
        }
        
     // 3. JWTトークン生成
        String token = jwtTokenProvider.generateToken(user);

        // 4. レスポンスDTOに詰めて返却
        return new LoginUserResponseDto(
            user.getId(),
            user.getUsername(),
            token
        );
    }
    
    @Override
    public LogoutUserResponseDto logoutUser(HttpServletRequest request) {
        // Authorizationヘッダーからトークン取得
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new RuntimeException("Authorizationヘッダーが不正です");
        }

        String token = authHeader.substring(7); // "Bearer " の後ろを取得

        // トークンを無効化（ブラックリストに登録）
        tokenBlacklistService.blacklistToken(token);

        return new LogoutUserResponseDto("ログアウトしました");
    }
}
