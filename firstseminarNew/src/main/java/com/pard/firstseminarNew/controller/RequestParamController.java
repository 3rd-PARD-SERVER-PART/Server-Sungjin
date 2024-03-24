package com.pard.firstseminarNew.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestParamController {
    @RequestMapping("/basic")
    public String requestParam(
            @RequestParam("name") String hiName,
            @RequestParam("age") int hiAge
    ){
        return "requestParam 연습  ==>  name : " + hiName + ", age : " + hiAge;
    }
}
