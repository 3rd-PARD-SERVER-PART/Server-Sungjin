package com.example.pardBackEnd_SJ.member.controller;

import com.example.pardBackEnd_SJ.member.dto.MemberCreateDTO;
import com.example.pardBackEnd_SJ.member.dto.MemberReadDTO;
import com.example.pardBackEnd_SJ.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pard")
//@CrossOrigin(origins= "*") // 아주 안 좋은 방식, 세션? 그곳에 개인 정보가 다 들어있기 때문에 "*"는 안됨
//@CrossOrigin(origins= {"http://localhost:3000", "http://localhost:3001"}, allowCredentials = "true")
// 위에꺼 대신 CorsConfig.java 사용
public class MemberController {
    private final MemberService memberService;

    @PostMapping("")
    public String createMember(@RequestBody MemberCreateDTO dto) {
        memberService.createMember(dto);
        return "파드에 가입을 축하드립니다."; // @RestController로 인해 HTTP 응답 본문에 자동으로 출력된다.
    }

    @GetMapping("")
    // part를 선택적으로 파라미터로 받음 -> 해당 파트에 속한 멤버를 조회 가능
    public List<MemberReadDTO> findMember(@RequestParam(required = false) String part) {
        if (StringUtils.hasText(part)) { // part 매개변수가 제공되면 해당 파트에 속한 멤버를 반환
            // http://localhost:8080/pard?part=server
            return memberService.findByPart(part);
        }
        // http://localhost:8080/pard
        return memberService.findAll(); // part 매개변수가 제공되지 않으면 모든 멤버를 반환
    }

    @GetMapping("/{id}")
    // http://localhost:8080/pard/1
    public MemberReadDTO findById(@PathVariable Long id) { // 주어진 ID에 해당하는 멤버를 조회
        return memberService.findById(id); // 해당 멤버가 존재하면 -> 해당 멤버의 정보를 반환
    }

//    @PatchMapping("api/blogs/{id}")
//    public Long update2(@PathVariable Long id, @RequestBody BlogRequestDto requestDto) throws SQLException {
//
//        return blogService.patchUpdate(id, requestDto);
//    }

    @PatchMapping("/{id}")
    public String updateById(@PathVariable Long id, @RequestBody MemberReadDTO dto) {
        memberService.update(id, dto);
        return "수정됨";
    }

    @DeleteMapping("/{id}")
    // http://localhost:8080/pard/1
    public String deleteById(@PathVariable Long id) {
        memberService.deleteById(id); // 주어진 ID에 해당하는 멤버를 삭제
        return "삭제됨";
    }
}
