package com.pard.firstseminarNew.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariableController {

    @RequestMapping("/pathV1/{name}")
    public String pathV1(@PathVariable("name") String userName) {
        return "PathVariable 연습 name : " + userName;
    }

    @RequestMapping("/pathV2/{name}")
    public String pathV2(@PathVariable String name) {
        return "PathVariable2 연습 name : " + name;
    }

    @RequestMapping("/pathV3/{name}/{age}")
    public String pathV3(@PathVariable String name, @PathVariable int age) {
        return "PathVariable 다중 연습 \n name : " + name + ", age : " + age;
    }
}
