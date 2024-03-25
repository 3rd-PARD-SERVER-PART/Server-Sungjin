package com.pard.firstseminarNew.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello.html";
    }

}

/*
완성시킬 떄: ctrl + shift + enter
먼가 이상할 떄: alt + enter

 */