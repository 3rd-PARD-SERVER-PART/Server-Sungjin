package com.pard.hw4.book.entity;
import jakarta.persistence.*;
import lombok.*;
import com.pard.hw4.book.dto.BookCreateDTO;
import com.pard.hw4.user.entity.User;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String name;

//    @ManyToOne // '여러 책'이 '하나의 사용자'에 속할 수 있다는 것을 의미
//    @JoinColumn(name = "user_id") // '@JoinColumn'은 외래 키를 지정하는 데 사용된다.
//    private User user;

    // 두둥
    @ColumnDefault("0")
    private boolean isLoan;

    public Book(BookCreateDTO dto) {
        this.name = dto.getName();
    }

    public Book(BookCreateDTO dto, User user) {
        this.name = dto.getName();
    }

    public void isReturn() {
        this.isLoan = !this.isLoan;
    }

}
