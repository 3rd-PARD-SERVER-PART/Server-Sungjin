package com.pard.hw5.config;

import org.springframework.boot.web.servlet.view.MustacheViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //수동으로 스프링 컨테이너에 Bean 등록하는 방법
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void configureViewResolvers(
            ViewResolverRegistry registry
    )
    {
        MustacheViewResolver resolver =
                new MustacheViewResolver();
        resolver.setCharset("UTF-8");
        resolver.setContentType("text/html;charset=UTF-8");
        resolver.setPrefix("classpath:/templates/");
        resolver.setSuffix(".html");
        registry.viewResolver(resolver);
    }
}

/*
원래 파일 이름이 ~.mustache 이어야 읽을 수 있지만
~.html 파일을 읽을 수 있게 하는 파일 코드

Mustache 템플릿 엔진을 사용하여 HTML 파일을 처리하기 위한 설정이다.
configureViewResolvers() 메서드를 오버라이드하여 Mustache 뷰 리졸버를 설정한다.
Mustache 뷰 리졸버는 클래스 패스 내의 templates/ 디렉토리에서 .html 확장자를 가진 파일을 읽을 수 있도록 설정한다.
 */