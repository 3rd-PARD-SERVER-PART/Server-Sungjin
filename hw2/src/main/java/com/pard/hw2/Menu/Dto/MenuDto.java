package com.pard.HW2.Menu.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuDTO {
    private Integer menuId;
    private String name;
    private int price;
    private String category;
}
