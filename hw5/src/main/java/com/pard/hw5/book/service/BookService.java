package com.pard.hw5.book.service;

import lombok.RequiredArgsConstructor;
import com.pard.hw5.book.dto.BookDTO;
import com.pard.hw5.book.entity.Book;
import com.pard.hw5.book.repo.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepo bookRepo;

    public void createBook(BookDTO.Create dto) {
        bookRepo.save(Book.toEntity(dto));
    }

    public List<BookDTO.Read> readAll() {
        return bookRepo.findAll().stream()
                .map(BookDTO.Read::new)
                .collect(Collectors.toList());
    }
}
