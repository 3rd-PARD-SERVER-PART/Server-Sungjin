package com.pard.SecondSeminar.User.repository;


import com.pard.SecondSeminar.User.User;
import com.pard.SecondSeminar.User.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private static final Map<Integer, User> handong = new HashMap<>();

    public void save(UserDto userDto){
        User u = User.builder()
                .studentName(userDto.getStudentName())
                .studentId(userDto.getStudentId())
                .build();

        handong.put(userDto.getStudentId(), u);
    }

    // Read
    public UserDto findById(Integer studentId){
        User user = handong.get(studentId);
        return UserDto.builder()
                .studentId(user.getStudentId())
                .studentName(user.getStudentName())
                .build();
    }

    public List<UserDto> findAll(){
        return handong.values().stream() // handong 맵의 값들을 스트림으로 변환합니다. 이 스트림은 맵에 있는 모든 사용자 객체를 포함한다.
                .map(user -> UserDto.builder()
                    .studentId(user.getStudentId())
                    .studentName(user.getStudentName())
                    .build()).toList();
    }

//    public List<UserDto> findAll(){
//        return handong.values().stream()
//                .map(user -> UserDto.builder()
//                        .studentId(user.getStudentId())
//                        .studentName(user.getStudentName())
//                        .build())
//                .collect(Collectors.toList());
//    }

//    public List<UserDTO> userDtos = new ArrayList<>();
//        for (User user : handong.values()) {
//        UserDTO userDto = UserDTO.builder()
//                .studentId(user.getStudentId())
//                .studentName(user.getStudentName())
//                .build();
//        userDtos.add(userDto);
//    }
//        return userDtos;



    //UPDATE
    public void update(Integer studentId, UserDto userDto){
        User user = handong.get(studentId);
        user.setStudentId(userDto.getStudentId());
        user.setStudentName(userDto.getStudentName());
//        handong.put(user.getStudentId(), user);
    }

    //DELETE
    public void delete(Integer studentId) {
        handong.remove(studentId);
    }
}
