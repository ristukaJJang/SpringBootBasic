package com.jhj.springbasic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

// Lombok 라이브러리
// getter, setter, 생성자, toString 등 자주 사용되지만 반복적인 작업을 자동으로 생성하는 라이브러리
// 프로젝트가 Lombok 라이브러리 의존성을 가지고 있어야 함
// 대부분의 IDE에서 Lombok 어노테이션을 읽을 수 없기 때문에 추가 확장 필요

// @Getter
// @Setter
// @toString(필드이름과 값을 문자열로 표현)
// @NoArgsConstructor : 빈 생성자 
// @AllArgsConstructor : 모든 멤버 변수를 초기화하는 생성자
// @RequiredArgsConstructor : 필수 멤버 변수를 초기화하는 생성자
// @Data : @Getter, @Setter, @RequiredArgsConstructor 등을 하나로 합친 어노테이션
@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
public class Lombok {
    final private String field1;
    final private String field2;
    private String field3;
    private boolean field4;
    private Boolean field5;
}
