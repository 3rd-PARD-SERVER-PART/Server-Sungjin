package com.pard.hw5.user.repo;

import com.pard.hw5.book.entity.Book;
import com.pard.hw5.user.entity.User;
import com.pard.hw5.user.entity.UserLoanHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoanHistoryRepo extends JpaRepository<UserLoanHistory, Long> {
    UserLoanHistory findByUserAndBookAndIsReturn(User user, Book book, boolean isReturn);
}
