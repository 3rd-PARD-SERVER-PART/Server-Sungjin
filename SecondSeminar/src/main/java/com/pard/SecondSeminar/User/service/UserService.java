package com.pard.SecondSeminar.User.service;


import com.pard.SecondSeminar.User.dto.UserDto;
import com.pard.SecondSeminar.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void saveUser (UserDto userDto){
        userRepository.save(userDto);
    }

    public UserDto findById(Integer studentId){
        return userRepository.findById(studentId);
    }

    public List<UserDto> findAll(){
        return userRepository.findAll();
    }

    public void update(Integer studentId, UserDto userDto){
        userRepository.update(studentId, userDto);
    }

    public void delete(Integer studentId){
        userRepository.delete(studentId);
    }
}
