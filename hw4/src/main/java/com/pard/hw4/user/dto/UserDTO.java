package com.pard.hw4.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import com.pard.hw4.book.dto.BookReadDTO;
import com.pard.hw4.user.entity.User;

import java.util.List;

public class UserDTO {
    @Getter
    @Setter
    public static class Create { // 새로운 사용자를 생성할 때 필요한 정보
        private String name;
    }
}



