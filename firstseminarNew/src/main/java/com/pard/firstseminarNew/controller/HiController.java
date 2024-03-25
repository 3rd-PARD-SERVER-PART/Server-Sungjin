package com.pard.firstseminarNew.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @RequestMapping("/hii")
    public String hi() {
        return "hello.html";
    }
}
