package com.pard.hw2.Menu.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuDto {
    private Integer menuId;
    private String name;
    private int price;
    private String category;
}
