package com.example.kendo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.kendo.entity.UserEntity;
import com.example.kendo.repository.UserRepository;
import com.example.kendo.security.UserPrincipal;
import com.example.kendo.service.CustomUserDetailsService;

@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("ユーザーが見つかりません: " + email);
        }
        return new UserPrincipal(user.getId(), user.getEmail(), user.getPassword());
    }
    
    @Override
    public UserDetails loadUserById(Long userId) throws UsernameNotFoundException {
        UserEntity user = userRepository.findById(userId);
        if (user == null) {
            throw new UsernameNotFoundException("ユーザーが見つかりません: ID=" + userId);
        }
        return new UserPrincipal(user.getId(), user.getEmail(), user.getPassword());
    }
}
