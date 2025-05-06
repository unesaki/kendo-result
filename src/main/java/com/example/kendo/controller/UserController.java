package com.example.kendo.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kendo.requestDto.LoginUserRequestDto;
import com.example.kendo.requestDto.RegisterUserRequestDto;
import com.example.kendo.responseDto.LoginUserResponseDto;
import com.example.kendo.responseDto.RegisterUserResponseDto;
import com.example.kendo.service.UserService;



@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {
	
	@Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponseDto> register(@RequestBody @Valid RegisterUserRequestDto requestDto) {
        RegisterUserResponseDto responseDto = userService.registerUser(requestDto);
        return ResponseEntity.status(201).body(responseDto);
    }
    
    @PostMapping("/login")
    public ResponseEntity<LoginUserResponseDto> login(
            @RequestBody @Valid LoginUserRequestDto requestDto) {
        
        userService.login(requestDto);
        return ResponseEntity.ok(new LoginUserResponseDto("ログインに成功しました。"));
    }
    
    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        return ResponseEntity.ok("ログアウトしました。");
    }


}
