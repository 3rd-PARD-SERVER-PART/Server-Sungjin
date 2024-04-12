package com.pard.hw3.Menu.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;

    @Column(name = "name")
    private String menuName;

    @Column(name = "price")
    private double menuPrice;

    @Column(name = "category")
    private String menuCategory;
    //  burger / side / icecream / beverage

    @Column(name = "rating")
    private double menuRating;
    // 1 ~ 5

}
