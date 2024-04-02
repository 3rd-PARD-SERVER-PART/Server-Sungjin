package com.pard.SecondSeminar.User.controller;

import com.pard.SecondSeminar.User.dto.UserDto;
import com.pard.SecondSeminar.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService; // 의존성 주입 -> UserController가 userService에 의존하고 있다

    @PostMapping("")
    public void saveUser(@RequestBody UserDto userDto){ // client에서 server로 JSON 형태로 보내야 하기 때문에 @RequestBody를 사용한다.
        userService.saveUser(userDto);
    }

    @GetMapping("/{studentId}")
    public UserDto findById(@PathVariable Integer studentId){
        return userService.findById(studentId);
    }

    @GetMapping("")
    public List<UserDto> findByAll(){
        return userService.findAll();
    }

    @PatchMapping("/{studentId}")
    public void update(@PathVariable Integer studentId, @RequestBody UserDto userDto){
        userService.update(studentId, userDto);
    }

    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable Integer studentId){
        userService.delete(studentId);
    }
}
