package com.example.kendo.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kendo.dto.RegisterUserRequestDto;
import com.example.kendo.service.UserService;



@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterUserRequestDto requestDto) {
        userService.register(requestDto);
        return ResponseEntity.status(201).body("ユーザー登録が完了しました。");
    }

}
