package com.jhj.springbasic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jhj.springbasic.entity.SampleUserEntity;
import java.util.*;
import java.util.List;


// 리포지토리는 인터페이스!
@Repository
public interface SampleUserRepository 
extends JpaRepository<SampleUserEntity, String>{
    // <바꾸고자 하는 클래스, pk의 원래 데이터형>

    // Query Method : Repository의 메서드 선언 시에 특정 패턴에 따라 메서드명을 작성하면 JPA가 SQL을 만들어주는 방식
    // - findBy : 필드명을 기준으로 모든 컬럼을 조회, findBy 뒤에 필드명을 붙임, 필드명의 첫글자는 대문자

    // ex) select * from sample_user where name = '김철수';
    List<SampleUserEntity> findByName(String name);

    // ex) select * from sample_user where tel_number = '?'; **tel_number unique
    SampleUserEntity findByTelNumber(String telNumber);

    // And/Or : 논리 and / or 연산에 사용, 필드와 필드 사이에 위치
    // And/Or 우선순위 주의, And > Or
    // ex) select * from sample_user where name = '?' and address = '?';
    List<SampleUserEntity> findByNameAndAddress(String name, String address);

    // Like, NotLike, StartingWith, EndingWith, Containing : LIKE 연산에 대해 사용, 필드 뒤에 사용
    // ex) select * from sample_user where address like '%부산%';
    List<SampleUserEntity> findByAddressContaining(String address);

    // OrderBy : 정렬을 사용할 필드를 지정하여 Desc or Asc 지정 가능
    // ex) select * from sample_user where name='?' order by tel_number desc;
    List<SampleUserEntity> findByNameOrderByTelNumberDesc(String name);

    // existsBy : 조건에 해당하는 레코드가 존재하는지 확인할 때 사용
    boolean existsByName(String name);

    // countBy : 조건에 해당하는 레코드의 개수를 반환
    int countByName(String name);

    // @Query : 쿼리 메서드의 한계를 극복하기 위해 사용하는 방식
    // - 쿼리 메서드가 사용할 수 없는 복잡한 쿼리를 직접 작성하는 방법

    // JPQL(Java Persistence Query Language)
    // 표준 sql과 매우 흡사하지만 엔터티 클래스와 엔터티 필드로 쿼리 작성
    // ex) select * from sample_user where name = '?' and address = '?';
    @Query(value = "SELECT u FROM user u WHERE u.name = ?1 AND u.address = ?2")
    List<SampleUserEntity> getJpql(String name, String address);

    @Query(value = "SELECT u FROM user u WHERE u.name = :name AND u.address = :address")
    List<SampleUserEntity> getJpql2(
        @Param("name") String name, 
        @Param("address") String address
        );

    // Native SQL : 현재 RDBMS의 SQL 문법을 그대로 사용하는 방법
    // @Query nativeQuery 속성을 반드시 true로 지정
    @Query(value = "SELECT * FROM sample_user WHERE name = :name AND address = :address", 
    nativeQuery = true)
    List<SampleUserEntity> getNativeSql(
        @Param("name") String name,
        @Param("address") String address
        );

    boolean existsByUserId(String userId);
    boolean existsByTelNumber(String telNumber);


    SampleUserEntity findByUserId(String userId);

}
