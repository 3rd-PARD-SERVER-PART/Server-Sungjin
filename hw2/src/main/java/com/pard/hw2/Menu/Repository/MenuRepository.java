package com.pard.hw2.Menu.Repository;

import com.pard.hw2.Menu.Dto.MenuDto;
import com.pard.hw2.Menu.Menu;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MenuRepository {
    private static final Map<Integer, Menu> menus = new HashMap<>();

    // CREATE
    public void save(MenuDto menuDto){
        Menu menu = Menu.builder()
                .menuId(menuDto.getMenuId())
                .name(menuDto.getName())
                .price(menuDto.getPrice())
                .category(menuDto.getCategory()) // 카테고리 추가
                .build();

        menus.put(menuDto.getMenuId(), menu);
    }

    // READ All
    public List<MenuDto> findAll(){
        return menus.values().stream()
                .map(menu -> MenuDto.builder()
                        .menuId(menu.getMenuId())
                        .name(menu.getName())
                        .price(menu.getPrice())
                        .category(menu.getCategory()) // 카테고리 추가
                        .build())
                .collect(Collectors.toList());
    }

    // READ By Id
    public MenuDto findById(Integer menuId) {
        Menu menu = menus.get(menuId);
        return MenuDto.builder()
                .menuId(menu.getMenuId())
                .name(menu.getName())
                .price(menu.getPrice())
                .category(menu.getCategory()) // 카테고리 추가
                .build();
    }

    // UPDATE
    public void update(Integer menuId, MenuDto menuDto){
        Menu menu = menus.get(menuId);
        menu.setName(menuDto.getName());
        menu.setPrice(menuDto.getPrice());
        menu.setCategory(menuDto.getCategory()); // 카테고리 추가
    }

    // DELETE
    public void delete(Integer menuId) {
        menus.remove(menuId);
    }
}
