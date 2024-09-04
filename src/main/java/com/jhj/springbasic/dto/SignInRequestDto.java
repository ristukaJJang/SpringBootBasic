package com.jhj.springbasic.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignInRequestDto {
    
    @NotBlank
    private String userId;
    
    @NotBlank
    private String password;    
}
