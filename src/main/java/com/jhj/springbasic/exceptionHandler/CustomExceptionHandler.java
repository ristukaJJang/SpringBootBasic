package com.jhj.springbasic.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// @RestControllerAdvice : RestController에서 발생하는 특정 상황에 대해 처리하는 클래스로 지정
@RestControllerAdvice
public class CustomExceptionHandler {
    
    // @ExceptionHandler : 지정한 예외에 대해 직접 컨트롤 할 수 있도록 하는 어노테이션
    // @ExceptionHandler(value={예외클래스, ...})
    @ExceptionHandler(value={MethodArgumentNotValidException.class})
    public ResponseEntity<String> customException(MethodArgumentNotValidException exception) {
        exception.printStackTrace();
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("잘못된 입력입니다.");
    }
}
