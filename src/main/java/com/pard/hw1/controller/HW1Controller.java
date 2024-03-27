package com.pard.hw1.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HW1Controller {

    @RequestMapping("/sungjin/{name}/{age}/{dept}/{hobby}")
    public String sungjin(@PathVariable String name, @PathVariable Integer age, @PathVariable String dept, @PathVariable String hobby) {
        return "<나의 정보> name : 오성진 / age : 23 / dept : CS / hobby : Music  ///  <상대방 정보>  \n name : " + name + " / age : " + age + " / dept : " + dept + " / hobby : " + hobby;
    }

//    @RequestMapping("/junhyung")
//    public String requestInfo(
//            @RequestParam(defaultValue = "친구이름") String name,
//            @RequestParam(defaultValue = "3") Integer age,
//            @RequestParam(defaultValue = "친구전공") String major,
//            @RequestParam(defaultValue = "친구취미") String hobby
//    ){
//        return "이준형/26/컴공/서핑 <<<<<< 여기부터 짝꿍꺼 <<<<<< " + name + "/" + age + "/" + major + "/" + hobby;
//    }

//    @RequestMapping("/sungjin/{name}/{age}/{dept}/{hobby}")
//    public String my(
//            @RequestParam(defaultValue = "오성진") String name,
//            @RequestParam(defaultValue = "23") int age,
//            @RequestParam(defaultValue = "CS") String dept,
//            @RequestParam(defaultValue = "Music") String hobby){
//        return "<나의 정보> : 오성진 / 23 / CS / Music  ///  <상대방 정보>  \n name : " + name + " / age : " + age + " / dept : " + dept + " / hobby : " + hobby;
//    }

}