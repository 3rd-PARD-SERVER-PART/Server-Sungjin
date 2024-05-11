package com.example.pardBackEnd_SJ.member.entity;

import com.example.pardBackEnd_SJ.member.dto.MemberCreateDTO;
import com.example.pardBackEnd_SJ.member.dto.MemberReadDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id; // 멤버 id
    private String name; // 멤버 이름
    private String part; // 멤버 파트
    private int age; // 멤버 나이

    // MemberCreateDTO 객체 --> Member Entity 로 변환
    // DTO를 사용하여 클라이언트로부터 전달된 데이터를 엔티티로 변환할 때 사용하는 메서드
    public Member toEntity(MemberCreateDTO dto) {
        return Member.builder()
                // MemberCreateDTO 객체로부터 받은 속성들을 Member 엔티티의 속성에 대입
                // .[Member 엔티티 속성]([MemberCreateDTO 객체].get[변수]())
                .age(dto.getAge())
                .part(dto.getPart())
                .name(dto.getName())
                .build();
    }

    public void update(MemberReadDTO dto){
        this.name = dto.getName();
        this.part = dto.getPart();
        this.age = dto.getAge();
    }
}
