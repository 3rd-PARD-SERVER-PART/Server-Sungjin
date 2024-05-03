package com.pard.hw4.book.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// 새 책을 생성하는 데 사용되는 데이터 전송 객체(DTO)
public class BookCreateDTO {
    private String name; // 책의 이름
    private Long userId; // 해당 책을 소유하는 사용자의 ID
}
