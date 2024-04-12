package com.pard.hw3.Menu.repository;

import com.pard.hw3.Menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
/*
Java에서 인터페이스의 메서드는 자동으로 public으로 간주되기 때문에 별도로 명시하지 않아도 되기 때문에
메서드 선언부에 public 생략 가능 !!
*/
    List<Menu> findByMenuPriceBetween(double minPrice, double maxPrice);

    List<Menu> findByMenuCategory(String category);

    List<Menu> findByMenuRatingBetween(double minRating, double maxRating);

}

/*
나만의 메서드 추가

1. 가격 별로 조회 (가능하면, 얼마에서 얼마 사이인지 조회)

2. 카테고리 별로 조회 (버거, 사이드, 음료, 디저트, 샐러드)

3. 별점 별로 조회 (rating 1.0 ~ 5.0) (아니면 1 ~ 5)

 */