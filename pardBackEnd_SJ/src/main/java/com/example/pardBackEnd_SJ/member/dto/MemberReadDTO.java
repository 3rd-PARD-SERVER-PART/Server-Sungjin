package com.example.pardBackEnd_SJ.member.dto;

import com.example.pardBackEnd_SJ.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberReadDTO { // 멤버 정보를 읽을 때 사용
    private Long id;
    private String name;
    private String part;
    private int age;

    // Member 엔티티 객체 --> MemberReadDTO 변환하는 메서드
    // Entity를 DTO로 변환
    // 클라이언트로 전송할 수 있는 형태로 변환할 때 사용함.
    public MemberReadDTO toDTO(Member member) {
        return MemberReadDTO.builder()
                .id(member.getId())
                .age(member.getAge())
                .name(member.getName())
                .part(member.getPart())
                .build();
    }
}

/*
    클라이언트에게 데이터를 전달할 때 사용됨.
*/

