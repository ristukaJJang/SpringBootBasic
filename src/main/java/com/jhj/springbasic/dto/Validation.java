package com.jhj.springbasic.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// client request body 데이터의 유효성 검사
// - spring-boot-starter-validation 라이브러리 사용
// - 스프링 프레임워크에서 제공하는 유효성 검사 인터페이스 라이브러리
// - 클라이언트가 서버측에 데이터를 전송할 때 유효성을 검사하고 정확한 데이터만 받을 수 있도록 도움

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Validation {
    
    // @NotNull : null을 허용하지 않음
    @NotNull
    private String notNull;

    // client로부터 데이터를 받을 때는 기본형 데이터 타입 사용 지양
    @NotNull
    //@NotBlank 쓰면 안됨 문자열만 검사 가능
    private Integer number;

    // @NotEmpty : 문자열 타입에서 null과 빈문자열("")을 허용하지 않음
    @NotEmpty
    private String notEmpty;

    // @NotBlank : 문자열 타입에서 null, 빈문자열(""), 공백문자열("  ")을 허용하지 않음
    @NotBlank
    private String notBlank;

    // @Length(min=?, max=?) : 문자열 타입에서 길이의 최소 최대를 지정
    @Length(min=4)
    @NotNull
    private String length;

    // @Min(), @Max() : 정수의 최소, 최대값 지정
    @Min(10)
    @Max(20)
    private int minMax;

    // @Range(min=?, max=?)
    @Range(min=5,max=20)
    private Integer range;

    // @Size(min=?, max=?) : 컬렉션의 길이 최소, 최대값 지정
    @Size(min=2,max=4)
    private Integer[] size;

    // @Pattern(regexp=정규식) : 정규식을 이용하여 문자열의 패턴 검사
    @Pattern(regexp="^[a-zA-Z]*$")
    private String pattern;
}
