package com.pard.hw5.book.controller;

import lombok.RequiredArgsConstructor;
import com.pard.hw5.book.dto.BookDTO;
import com.pard.hw5.book.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BookController {
    private final BookService bookService;
    @PostMapping("/book")
    public String createUser(@RequestBody BookDTO.Create dto) {
        bookService.createBook(dto);
        return "추가됨";
    }

    @GetMapping("/book")
    public List<BookDTO.Read> readAll() {
        return bookService.readAll();
    }
}
