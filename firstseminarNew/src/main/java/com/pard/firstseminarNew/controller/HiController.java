package com.pard.firstseminarNew.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @RequestMapping("/hi")
    public String hi() {
        return "hello.html"; // 데이터 자체를 반환 -> 데이터를 넘기는 벡엔드(API서버)에 특화됨
    }
}
