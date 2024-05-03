package com.pard.hw4.user.controller;

import com.pard.hw4.user.dto.UserLoanDTO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import com.pard.hw4.user.dto.UserDTO;
import com.pard.hw4.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    @Operation(summary = "유저 등록", description = "유저를 이름과 전공과 나이를 통해 생성합니다.")
    public String createUser(@RequestBody UserDTO.Create dto) { // 요청의 본문을 UserDTO.Create 객체로 매핑
        userService.createUser(dto);
        return "Create User";
    }

    @GetMapping("/user")
    public List<UserLoanDTO.Read> readAll() {
        return userService.readAll();
    }


    @GetMapping("/user/{userId}")
    public UserLoanDTO.Read readById(@PathVariable Long userId) {
        return userService.readById(userId);
    }

    @PostMapping("/loan")
    public String loan(@RequestBody UserLoanDTO.Loan dto) {
        return userService.borrow(dto);
    }


    @PostMapping("/return")
    public String returnBook(@RequestBody UserLoanDTO.Loan dto) {
        return userService.returnBook(dto);
    }
}
