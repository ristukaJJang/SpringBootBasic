package com.jhj.springbasic.service;

import com.jhj.springbasic.dto.PostUserRequestDto;
import com.jhj.springbasic.dto.SignInRequestDto;

import jakarta.validation.Valid;

public interface AuthService {
    String signUp(PostUserRequestDto dto);
    String signIn(SignInRequestDto requestBody);
}
