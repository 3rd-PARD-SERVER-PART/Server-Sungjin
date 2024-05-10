package com.example.pardBackEnd_SJ.member.repo;

import com.example.pardBackEnd_SJ.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepo extends JpaRepository<Member, Long> {

   List<Member> findByPart(String part);
}

/*
   Spring Data JPA에서 제공하는 표준적인 JpaRepository 인터페이스의 기능을 상속
   <Member, Long> :  엔티티 타입 + 그 엔티티의 ID 타입
   Spring Data JPA의 Query Creation 기능을 사용해서, 자동으로 part 별로 데이터를 찾는 쿼리를 생하고 실행한다.
*/