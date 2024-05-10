package com.pard.hw5.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("5차 과제")
                        .description("설명")
                        .version("1.0.0"));
    }
}
//
///*
//swagger 쓰려고 할 때
//application.properties에 필요한 코드:
//implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0'
//
// */