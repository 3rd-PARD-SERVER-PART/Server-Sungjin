package com.pard.hw4.book.service;

import lombok.RequiredArgsConstructor;
import com.pard.hw4.book.dto.BookCreateDTO;
import com.pard.hw4.book.dto.BookReadDTO;
import com.pard.hw4.book.entity.Book;
import com.pard.hw4.book.repo.BookRepo;
import com.pard.hw4.user.dto.UserDTO;
import com.pard.hw4.user.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // final로 선언된 필드에 대한 생성자를 자동으로 생성한다.
public class BookService {
    private final BookRepo bookRepo;
    private final UserRepo userRepo;
    // final을 쓰는 이유 : final을 안 쓰면 bookRepo를 인식 못함.
    // final에 해당하는 메서드를 불러오기는 가능, 하지만 메서드의 이름 수정 등은 불가능

    public void createBook(BookCreateDTO dto) {
//        User user = userRepo.findById(dto.getUserId()).orElseThrow());
        bookRepo.save(new Book(dto,
                userRepo.findById(dto.getUserId()).orElseThrow()));
    }

    public List<BookReadDTO> findAll() {
        return bookRepo.findAll().stream()
                .map(BookReadDTO::new)
                .collect(Collectors.toList());
    }
}

