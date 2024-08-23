package com.jhj.springbasic.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhj.springbasic.service.BasicService;
import com.jhj.springbasic.service.implement.BasicServiceImplement;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final이 붙은 필수값만 입력받음
@RestController
@RequestMapping("/service")
public class ServiceController {

    // 의존성 주입(DI) : 해당 모듈에 필요한 의존성을 외부(클래스의 인스턴스를 생성하는 위치)에서 주입
    // 생성자, setter, 필드를 통한 의존성 주입이 있다.
    // spring framework에서 권장하는 의존성 주입 방법 : 생성자(의존성이 주입되지 않은 상태가 존재할 수 없음)
    // spring framework에서 IoC(제어 역전)을 통해 의존성을 주입할 땐
    // 주입할 인스턴스의 클래스가 Spring Bean으로 등록되어 있어야 한다.
    //private BasicService basicService = new BasicServiceImplement(); 

    // @Autowired : 등록된 Spring bean을 제어 역전을 통해 의존성 주입을 할 수 있도록 하는 어노테이션
    // 필드 객체
    // @Autowired
    // private BasicService basicService2;

    // setter 메서드
    private final BasicService basicService;
    // @Autowired
    // public void setBasicService(BasicService basicService2) {
    //     this.basicService2 = basicService2;
    // }

    // 생성자 : @Autowired 필요 X, 이제부터 생성자는 롬복으로
    // public ServiceController(BasicService basicService) {
    //     this.basicService = basicService;
    // }

    private Date today;

    @GetMapping("")
    public ResponseEntity<String> getService() {
        return basicService.getService();
    }
}
