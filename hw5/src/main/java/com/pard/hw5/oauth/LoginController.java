package com.pard.hw5.oauth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/loginForm")
    public String login(){
        return "loginForm";
    }
}

/*

'/loginForm' 경로로 GET 요청이 들어오면 로그인 폼을 표시하는 컨트롤러이다.
사용자가 인증되지 않은 경우 로그인 페이지로 이동한다.

 */