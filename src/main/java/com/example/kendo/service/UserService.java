package com.example.kendo.service;

import com.example.kendo.dto.LoginUserRequestDto;
import com.example.kendo.dto.RegisterUserRequestDto;

public interface UserService {
	void register(RegisterUserRequestDto requestDto);
	void login(LoginUserRequestDto requestDto);
}
