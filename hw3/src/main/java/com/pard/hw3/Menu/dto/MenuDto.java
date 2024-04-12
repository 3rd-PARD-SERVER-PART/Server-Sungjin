package com.pard.hw3.Menu.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuDto {
    private String name;
    private double price;
    private String category;
    private double rating;
}
