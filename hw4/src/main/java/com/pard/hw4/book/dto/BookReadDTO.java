package com.pard.hw4.book.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.pard.hw4.book.entity.Book;
import com.pard.hw4.user.dto.UserDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookReadDTO {
    @Getter
    @Setter
    private Long bookId;
    private String name;
    private boolean isLoan;

    public BookReadDTO(Book book) {
        this.bookId = book.getBookId();
        this.name = book.getName();
        this.isLoan = book.isLoan();
    }

}
