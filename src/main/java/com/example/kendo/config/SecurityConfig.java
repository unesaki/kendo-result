package com.example.kendo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // パスワードエンコーダ（そのままでOK）
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Spring Security のアクセス制御設定を追加
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // CSRF無効化（PostmanなどからのPOST用）
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // 全てのリクエストを許可（開発用）
            );
        return http.build();
    }
}
