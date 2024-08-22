package com.jhj.springbasic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

// Controller 레이어
// - 클라이언트와 서버간의 접점
// - 클라이언트의 요청을 받고 해당 요청에 대한 응답 처리
// - 각 요청에 해당하는 url 메서드 작성하는 영역

// @Controller : 해당 클래스가 컨트롤러 레이어임을 명시 단, 응답 데이터가 html 형식
// @ResponseBody : 응답의 데이터 타입을 html이 아닌 json으로 지정
// @RestController : @Controller + @ResponseBody, json 형식 데이터 반환하는 컨트롤러 명시
@RestController

// @RequestMapping : http 요청에 클래스와 메서드를 url으로 매핑하기 위한 어노테이션
// http get localhost:4000/main/** 
// @RequestMapping(value = "/main", method = RequestMethod.GET)
@RequestMapping("/basic")
public class BasicController {

    @RequestMapping(value = "/first", method = RequestMethod.GET)
    public String firstMethod() {
        return "첫번째 REST API 요청 응답입니다.";
    }


// HTTP GET method : 클라이언트가 서버로부터 데이터를 받기 위한 메서드, Request Body 존재 X
@GetMapping("/")
public String getMethod() {
    return "GET Method";
}

// HTTP POST method : 클라이언트가 서버에 리소스를 작성하기 위한 메서드, Request Body 존재 O
@PostMapping("")
public String postMethod() {
    return "POST Method";
}

// HTTP PUT method : 클라이언트가 서버에 리소스를 전체 수정하기 위한 메서드, Request Body 존재 O
@PutMapping("")
public String putMethod() {
    return "PUT Method";
}

// HTTP PATCH method : 클라이언트가 서버에 리소스를 일부 수정하기 위한 메서드, Request Body 존재 O 
@PatchMapping("")
public String patchMethod() {
    return "PATCH Method";
}

// HTTP DELETE method : 클라이언트가 서버에 리소스를 삭제하기 위한 메서드, Request Body 존재 X
@DeleteMapping("")
public String deleteMethod() {
    return "DELETE Method";
}

// method + url pattern이 중복되면 서버 실행 중에 에러 발생
// @GetMapping("/first")
// public String getFirst() {
//     return "get first";
// }

}

