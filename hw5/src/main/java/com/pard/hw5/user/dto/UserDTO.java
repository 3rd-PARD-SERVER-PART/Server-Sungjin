package com.pard.hw5.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import com.pard.hw5.user.entity.User;

import java.util.List;

public class UserDTO {

    @Getter
    @Setter
    @Builder
    public static class Create {
        private String name;
        private String email;
    }

    @Getter
    @Setter
    @Builder
    public static class Read {
        private Long userId;
        private String name;
        private String email;

        private List<UserLoanDTO.LoanRead> userLoanHistories;

        public static Read toDTO(User entity, List<UserLoanDTO.LoanRead> history) {
            return Read.builder()
                    .userId(entity.getUserId())
                    .name(entity.getName())
                    .email(entity.getEmail())
                    .userLoanHistories(history)
                    .build();
        }
    }
}
