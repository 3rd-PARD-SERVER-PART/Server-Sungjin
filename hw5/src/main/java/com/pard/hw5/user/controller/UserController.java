package com.pard.hw5.user.controller;

import com.pard.hw5.user.dto.UserLoanDTO;
import lombok.RequiredArgsConstructor;
import com.pard.hw5.user.dto.UserDTO;
import com.pard.hw5.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public String createUser(@RequestBody UserDTO.Create dto) {
        userService.create(dto);
        return "추가됨";
    }

    @GetMapping("/user")
    public List<UserDTO.Read> readAll() {
        return userService.readAll();
    }


    @PostMapping("/loan")
    public String loan(@RequestBody UserLoanDTO.Loan dto) {
        return userService.borrow(dto);
    }


    @PostMapping("/return")
    public String returnBook(@RequestBody UserLoanDTO.Loan dto) {
        return userService.returnBook(dto);
    }

    @GetMapping("/user/{userId}")
    public UserDTO.Read readById(@PathVariable Long userId) {
        return userService.readById(userId);
    }

}
