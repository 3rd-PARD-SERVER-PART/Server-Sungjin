package com.pard.hw5.oauth;

import com.pard.hw5.user.dto.UserDTO;
import com.pard.hw5.user.repo.UserRepo;
import com.pard.hw5.user.service.UserService;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
    // loadUser는 구글에서 유저 프로필 받아옴

//    private final UserRepo userRepo;
    private final UserService userService;

    public PrincipalOauth2UserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest)
            throws OAuth2AuthenticationException {
        log.info("google 에서 받아온 userRequest:" + oAuth2UserRequest );

        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
        log.info("oauth에서 받아온 정보 : " + oAuth2User.getAttributes());

        String name = (String) oAuth2User.getAttribute("name");
        String email = (String) oAuth2User.getAttribute("email");

//        userService.create();
        // UserDTO.Create 객체 생성
        UserDTO.Create userCreateDTO = UserDTO.Create.builder()
                .name(name)
                .email(email)
                .build();
        // UserService를 통해 사용자를 저장
        userService.create(userCreateDTO);


        // OAuth2User를 반환
        return super.loadUser(oAuth2UserRequest);
    }


}

/*

OAuth 2.0을 사용하여 사용자 정보를 가져오는 서비스이다.
loadUser() 메서드를 오버라이드하여 구글에서 받은 사용자 정보를 로그에 출력한다.
이 서비스로 DefaultOAuth2UserService를 상속받아 OAuth 2.0을 통해 사용자 정보를 가져온다.

 */