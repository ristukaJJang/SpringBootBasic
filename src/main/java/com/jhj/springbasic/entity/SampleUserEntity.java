package com.jhj.springbasic.entity;

import com.jhj.springbasic.dto.PostUserRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name="user") // userid, password 등의 클래스를 string에서 SampleUserEntity로 바꿔주는 어노테이션
@Table(name="sample_user") // DB에 있는 테이블과 매핑시켜주는 어노테이션
@Builder
public class SampleUserEntity {

    @Id
    private String userId;

    private String password;
    private String name;
    private String address;
    private String telNumber;

    public SampleUserEntity(PostUserRequestDto dto) {
        this.userId = dto.getUserId();
        this.password = dto.getPassword();
        this.name = dto.getName();
        this.address = dto.getAddress();
        this.telNumber = dto.getTelNumber();
    }
}
