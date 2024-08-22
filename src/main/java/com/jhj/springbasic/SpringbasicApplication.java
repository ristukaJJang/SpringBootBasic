package com.jhj.springbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jhj.springbasic.dto.Lombok;

@SpringBootApplication
public class SpringbasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbasicApplication.class, args);
	}

	void lombokExample() {
		Lombok lombok = new Lombok("a", "b", "c", false, false);
		lombok.getField1();
		lombok.setField3(null);

		//lombok = new Lombok();
		lombok = new Lombok("d", "e");

		// 기본형 boolean일 경우 getter 메서드 이름은 isXXX()이다.
		lombok.isField4();

		// 참조형 Boolean일 경우 get 메서드 사용, null값을 받을 수 있기 때문이다.
		// 기본형 boolean : (true, false), 참조형 Boolean : (true, false, null)
		lombok.getField5();
	}
	
}
