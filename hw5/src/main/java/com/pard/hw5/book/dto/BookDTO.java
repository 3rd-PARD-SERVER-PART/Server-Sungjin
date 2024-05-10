package com.pard.hw5.book.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import com.pard.hw5.book.entity.Book;

public class BookDTO {
    @Getter
    @Setter
    public static class Create {
        private String name;
    }
    @Getter
    @Setter
    @Builder
    public static class Loan {
        private Long bookId;
        private String name;
        private boolean isLoan;
    }
    @Getter
    @Setter
    public static class Read {
        private Long bookId;
        private String name;
        private boolean isLoan;

        public Read(Book book) {
            this.bookId = book.getBookId();
            this.name = book.getName();
            this.isLoan = book.isLoan();
        }
    }
}
