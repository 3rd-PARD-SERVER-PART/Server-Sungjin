package com.example.pardBackEnd_SJ.member.dto;

import lombok.Getter;

@Getter
public class MemberCreateDTO { // 멤버를 생성할 떄 필요한 변수들 [이름, 파트, 나이]
    // id는 자동으롯 생성됨.
    private String name;
    private String part;
    private int age;

}
