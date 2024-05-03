package com.pard.hw4.user.service;

import com.pard.hw4.book.entity.Book;
import com.pard.hw4.book.repo.BookRepo;
import com.pard.hw4.user.dto.UserLoanDTO;
import com.pard.hw4.user.entity.UserLoanHistory;
import com.pard.hw4.user.repo.UserLoanHistoryRepo;
import com.pard.hw4.user.dto.UserDTO;
import com.pard.hw4.user.entity.User;
import com.pard.hw4.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final BookRepo bookRepo;
    private final UserLoanHistoryRepo userLoanHistoryRepo;

    public void createUser(UserDTO.Create dto) {
        userRepo.save(User.toEntity(dto));
    }

    public List<UserLoanDTO.Read> readAll() {
        return userRepo.findAll()
                .stream()
                .map(user -> UserLoanDTO.Read.toDTO(user,
                        user.getUserLoanHistories()
                                .stream()
                                .map(UserLoanDTO.LoanRead::toDTO)
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    public UserLoanDTO.Read readById(Long userId) {
        User user = userRepo.findById(userId).orElseThrow();
        return UserLoanDTO.Read.toDTO(user,user.getUserLoanHistories()
                .stream()
                .map(UserLoanDTO.LoanRead::toDTO)
                .collect(Collectors.toList()));
    }

    @Transactional
    public String borrow(UserLoanDTO.Loan dto) {
        Book book = bookRepo.findById(dto.getBookId()).orElseThrow();
        if (!book.isLoan()) {
            userLoanHistoryRepo.save(UserLoanHistory.toEntity(
                    userRepo.findById(dto.getUserId()).orElseThrow()
                    , bookRepo.findById(dto.getBookId()).orElseThrow()));
            book.isReturn();
            return "loan success";
        }
        return "loan failed";
    }

    @Transactional
    public String returnBook(UserLoanDTO.Loan dto) {
        Book book = bookRepo.findById(dto.getBookId()).orElseThrow();
        User user = userRepo.findById(dto.getUserId()).orElseThrow();
        UserLoanHistory userLoanHistory =
                userLoanHistoryRepo.findByUserAndBookAndIsReturn(user, book, false);
        if (!userLoanHistory.isReturn()) {
            userLoanHistory.isLoan();
            book.isReturn();
            return "return";
        }
        return "already returned";
    }



}
