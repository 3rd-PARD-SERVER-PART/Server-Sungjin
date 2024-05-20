package com.pard.firstseminarNew.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RequestParamController {
    @RequestMapping("/basic")
    public String requestParam(
            @RequestParam("name") String hiName,
            @RequestParam("age") int hiAge) {
        return "requestParam 연습 name : " + hiName + " age : " + hiAge;
    }

    @RequestMapping("/v2")
    public String requestParamV2(
            @RequestParam String name,
            @RequestParam int age) {
        return "requestParamV2 연습 name : " + name + " age : " + age;
    }
    @RequestMapping("/v3")
    public String requestParamV3(String name, int age) {
        return "requestParamV3 연습 name : " + name + " age : " + age;
    }

    @RequestMapping("/v4")
    public String requestParamV4(
            @RequestParam(required = true) String name,
            @RequestParam(required = false, defaultValue = "25") Integer age) {
        return "requestParamV4 연습 name : " + name + " age : " + age;
    }

    @RequestMapping("/default")
    public String requestParamDefault(
            @RequestParam(defaultValue = "guest") String name,
            @RequestParam(required = false, defaultValue = "-1") int age) {
        // "required= false" => 이 값이 무조건 있어야 한다.
        // 주소창에 age에 할당할 데이터를 입력 안 할거면, defaultValue 라도 넣어놔야 한다.

        return "requestParamV5 연습 name : " + name + " age : " + age;
    }

    @RequestMapping("/map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        return "requestParamV6 연습 name : " + paramMap.get("names") + ", age : " + paramMap.get("age");
    }
}

