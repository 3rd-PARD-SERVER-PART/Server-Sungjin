package com.pard.HW2.Menu;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Menu {
    private Integer menuId;
    private String name;
    private int price;
    private String category;
}

/*
어떤 서비스를  만들어볼까나

음식 메뉴 주문 관리 서비스
1. 메뉴 고유 id
2. 메뉴 이름
3. 메뉴 가격
4. 메뉴 카테고리
 */