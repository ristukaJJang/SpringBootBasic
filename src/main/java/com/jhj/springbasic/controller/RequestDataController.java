package com.jhj.springbasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jhj.springbasic.dto.Validation;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@RestController
// http:/localhost:4000/request-data/**
@RequestMapping("/request-data")
public class RequestDataController {
    
    // @RequestParam() : 
    // - get, delete 처럼 request body가 존재하지 않고 url로 데이터를 전송하는 메서드에서
    // query string 방식으로 데이터를 가져오기 위해 사용하는 어노테이션
    
    // get http://localhost:4000/request-data/request-param
    @GetMapping("/request-param")
    // http://localhost:4000/request-data/request-param?name=홍길동&age=30
    public String requestParam(
        //@RequestParam(name = "name") String name,
        @RequestParam("name") String name,
        @RequestParam(name = "age", required = false) Integer age
    ) {
        return "이름 : " + name + " 나이 : " + age;
    }

    // @PathVariable():
    // 모든 HTTP 메서드에서 URL의 특정 패턴에 따라 데이터를 추출
    // GET http://localhost:4000/request-data/path-variable/32692/*/*
    @GetMapping({
        "/path-variable/{var}/{str}",
        "path-variable/{var}/",
        "path-variable/{var}"
})
    public String pathVariable(
        @PathVariable(name = "var") String var,
        @PathVariable(name = "str", required=false) String str
    ) {
        return "읽은 경로 변수 : " + var + ", " + str;
    }

    // 주의
    // 경로 변수를 사용하여 URL 패턴을 작성할 때 겹치는 패턴이 존재하는지 확인
    @GetMapping("/path-variable/other")
    public String otherPathVariable() {
        return "other method 호출";
    }

    @GetMapping("/path-variable/{var}/another")
	public String anotherPathVariable1(
		@PathVariable("var") String var
	) {
		return "another1";
	}

	@GetMapping("/path-variable/another/{var}")
	public String anotherPathVariable2(
		@PathVariable("var") String var
	) {
		return "another2";
	}

    // @RequestBody()
    // - POST, PUT, PATCH 처럼 Request Body로 데이터를 전송하는 메서드에서 데이터를 읽기 위한 방법
    @PostMapping("/request-body")
    public String requestBody(
        //@RequestBody String requestBody
        @RequestBody SampleDto requestBody
    ) {
        return "Name : " + requestBody.getName()+ "\nAge : " + requestBody.getAge();
    }

    @PostMapping("/validation")
    public String validation(
        @RequestBody @Valid Validation requestBody
    ) {
        return "정상";
    }

}

// DTO(Date Transfer Object) : 데이터를 서로 다른 계층 간에 전송하기 위한 객체
// 캡슐화가 돼있음, 비즈니스 로직은 포함하지 않고 private 필드, 생성자, getter, setter만 존재
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class SampleDto {
    private String name;
    private int age;

}