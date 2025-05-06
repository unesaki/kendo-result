package com.example.kendo.service;

import com.example.kendo.requestDto.LoginUserRequestDto;
import com.example.kendo.requestDto.RegisterUserRequestDto;
import com.example.kendo.responseDto.LoginUserResponseDto;
import com.example.kendo.responseDto.RegisterUserResponseDto;

public interface UserService {
	RegisterUserResponseDto registerUser(RegisterUserRequestDto requestDto);
	LoginUserResponseDto loginUser(LoginUserRequestDto requestDto);
}
