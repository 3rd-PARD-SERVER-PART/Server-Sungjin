package com.pard.hw5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); //frontEnd에서 axios로 처리 가능하게 만들겠다
        config.addAllowedOrigin("*"); //모든 ip에 응답을 허용하겠다
        config.addAllowedHeader("*"); //모든 header에 응답을 허용하겠다
        config.addAllowedMethod("*"); //모든 post,get,put,delete,patch 요청을 허용하겠다
        source.registerCorsConfiguration("*", config); //api로 들어오는 모든 요청은 이 config를 따르겠다
        return new CorsFilter(source);
    }
}

/*

CorsConfig.java:
CORS (Cross-Origin Resource Sharing)를 설정하는 파일
CorsFilter Bean을 생성하여 cross-origin request (교차 출처 요청)을 허용한다.
config 객체를 생성하여 origin, header, method (출처, 헤더, 메서드)에 대한 규칙을 설정한다.
이 설정은 모든 출처(*)에서의 모든 요청들을 허용한다.

 */