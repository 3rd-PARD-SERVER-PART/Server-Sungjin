package com.pard.hw4.book.controller;

import lombok.RequiredArgsConstructor;
import com.pard.hw4.book.dto.BookCreateDTO;
import com.pard.hw4.book.dto.BookReadDTO;
import com.pard.hw4.book.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/book")
    public String createBook(@RequestBody BookCreateDTO dto) {
        bookService.createBook(dto);
        return "Create book";
    }

    @GetMapping("/book")
    public List<BookReadDTO> findAll() {
        return bookService.findAll();
    }

}
