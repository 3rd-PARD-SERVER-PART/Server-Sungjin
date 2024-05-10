package com.pard.hw5.user.dto;

import com.pard.hw5.user.entity.UserLoanHistory;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class UserLoanDTO {

    @Getter
    @Setter
    @Builder
    public static class Loan {
        private Long userId;
        private Long bookId;

        public static Loan toDTO(UserLoanHistory entity) {
            return Loan.builder()
                    .userId(entity.getUser().getUserId())
                    .bookId(entity.getBook().getBookId())
                    .build();
        }
    }

    @Getter
    @Setter
    @Builder
    public static class LoanRead {
        private String userName;
        private String bookName;
        private boolean isReturn;

        public static LoanRead toDTO(UserLoanHistory entity) {
            return LoanRead.builder()
                    .userName(entity.getUser().getName())
                    .bookName(entity.getBook().getName())
                    .isReturn(entity.isReturn())
                    .build();
        }

    }
}
