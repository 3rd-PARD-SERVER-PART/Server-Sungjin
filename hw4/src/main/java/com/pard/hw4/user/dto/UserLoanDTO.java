package com.pard.hw4.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pard.hw4.book.dto.BookReadDTO;
import com.pard.hw4.user.entity.User;
import com.pard.hw4.user.entity.UserLoanHistory;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class UserLoanDTO {

    @Getter
    @Setter
    @Builder
    public static class Loan { // 사용자가 소유한 책을 조회할 때 필요한 정보
        private Long userId;
        private Long bookId;
        public static UserLoanDTO.Loan toDTO(UserLoanHistory entity) {
            return Loan.builder()
                    .userId(entity.getUser().getId())
                    .bookId(entity.getBook().getBookId())
                    .build();
        }
    }
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL) // JSON에 포함하는데, null 값이 아닌 것만 포함해라.
    @Builder
    public static class LoanRead{
        private String userName;
        private String bookName;
        private boolean isReturn;
        public static UserLoanDTO.LoanRead toDTO(UserLoanHistory entity) {
            return LoanRead.builder()
                    .userName(entity.getUser().getName())
                    .bookName(entity.getBook().getName())
                    .isReturn(entity.getBook().isLoan())
                    .build();
        }
    }

    @Getter
    @Setter
    @Builder
    public static class Read{
        private Long userId;

        private String name;

        private List<LoanRead> userLoanHistories;
        public static UserLoanDTO.Read toDTO(User entity, List<LoanRead> history) {
            return Read.builder()
                    .userId(entity.getId())
                    .name(entity.getName())
                    .userLoanHistories(history)
                    .build();
        }
    }

}
