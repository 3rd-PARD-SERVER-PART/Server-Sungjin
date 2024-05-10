package com.pard.hw5.config;

import com.pard.hw5.oauth.PrincipalOauth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final PrincipalOauth2UserService principalOauth2UserService;
    private final CorsConfig corsConfig;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable);
        http.addFilter(corsConfig.corsFilter());
        http.authorizeHttpRequests(
                au -> au.anyRequest().permitAll()
        );
        http.oauth2Login(
                oauth -> oauth
                        .loginPage("/loginForm") // 이 주소로 이동해야 로그인 폼으로 이동함
                        .defaultSuccessUrl("/home")
                        .userInfoEndpoint(
                                userInfo ->
                                        userInfo.userService(principalOauth2UserService)
                        )
        );
        return http.build();
    }
}

/*
숏커톤, 롱커톤 때
security 관련 로직을 이 파일에서 수행함

애플리케이션의 보안 설정을 구성한다.
CorsConfig Bean을 주입하여 CORS 구성을 추가한다.
CSRF 보호를 비활성화하고, 모든 요청을 인가한다.
OAuth 2.0 로그인을 구성하여 사용자가 /loginForm으로 이동할 때 로그인 폼을 표시하고, 성공한 경우 /home으로 리디렉션한다.
 */