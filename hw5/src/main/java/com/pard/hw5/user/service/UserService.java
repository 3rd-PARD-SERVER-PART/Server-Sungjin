package com.pard.hw5.user.service;

import com.pard.hw5.user.dto.UserLoanDTO;
import lombok.RequiredArgsConstructor;
import com.pard.hw5.book.entity.Book;
import com.pard.hw5.book.repo.BookRepo;
import com.pard.hw5.user.dto.UserDTO;
import com.pard.hw5.user.entity.User;
import com.pard.hw5.user.entity.UserLoanHistory;
import com.pard.hw5.user.repo.UserLoanHistoryRepo;
import com.pard.hw5.user.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final BookRepo bookRepo;
    private final UserLoanHistoryRepo userLoanHistory;

//    public void create(UserDTO.Create dto) {
//        userRepo.save(User.toEntity(dto));
//    }

    public void create(UserDTO.Create dto) {
        User user = User.toEntity(dto);
        // UserDTO.Create를 User 엔티티로 변환 -> 이름과 이메일을 넘김.
        userRepo.save(user);
        log.info("User: Name: {}, Email: {}", user.getName(), user.getEmail());
    }


    @Transactional
    public String borrow(UserLoanDTO.Loan dto) {
        Book book = bookRepo.findById(dto.getBookId()).orElseThrow();
        if (!book.isLoan()) {
            userLoanHistory.save(UserLoanHistory.toEntity(
                    userRepo.findById(dto.getUserId()).orElseThrow()
                    , bookRepo.findById(dto.getBookId()).orElseThrow()));
            book.isReturn();
            return "loan success";
        }
        return "loan failed";
    }

    public List<UserDTO.Read> readAll() {
       return userRepo.findAll().stream()
                .map(user -> UserDTO.Read.toDTO(user
                        ,user.getUserLoanHistories()
                                .stream()
                                .map(UserLoanDTO.LoanRead::toDTO).
                                collect(Collectors.toList())

                        ))
                .collect(Collectors.toList());
    }

    public UserDTO.Read readById(Long userId) {
        User user = userRepo.findById(userId).orElseThrow();
        return UserDTO.Read.toDTO(user,user.getUserLoanHistories().stream().map(UserLoanDTO.LoanRead::toDTO).collect(Collectors.toList()));
    }
    @Transactional
    public String returnBook(UserLoanDTO.Loan dto) {
        Book book = bookRepo.findById(dto.getBookId()).orElseThrow();
        User user = userRepo.findById(dto.getUserId()).orElseThrow();
        UserLoanHistory userLoanHistory2 = userLoanHistory.findByUserAndBookAndIsReturn(user, book, false);
        if (!userLoanHistory2.isReturn()) {
            userLoanHistory2.isLoan();
            book.isReturn();
            return "return success";
        }
        return "already returned";
    }



}
