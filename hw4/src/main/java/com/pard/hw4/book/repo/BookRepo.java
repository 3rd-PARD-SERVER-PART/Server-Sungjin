package com.pard.hw4.book.repo;

import com.pard.hw4.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Long> {

}
/*
    BookRepo 인터페이스는 JpaRepository 인터페이스를 확장한다.
    JpaRepository는 스프링 데이터 JPA가 제공하는 기본적인 CRUD(Create, Read, Update, Delete) 메서드를 제공한다.
    즉, BookRepo 인터페이스는 Book 엔티티에 대한 CRUD 작업을 수행할 수 있는 메서드를 상속 받는 것이다.

    제네릭 타입: JpaRepository를 상속하면서 제네릭 타입으로는 엔티티 클래스(Book)와 식별자 타입(Long)을 지정한다.
*/