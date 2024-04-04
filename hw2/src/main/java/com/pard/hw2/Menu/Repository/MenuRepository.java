package com.pard.HW2.Menu.Repository;

import com.pard.HW2.Menu.DTO.MenuDTO;
import com.pard.HW2.Menu.Menu;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MenuRepository {
    private static final Map<Integer, Menu> menus = new HashMap<>();

    // CREATE
    public void save(MenuDTO menuDto){
        Menu menu = Menu.builder()
                .menuId(menuDto.getMenuId())
                .name(menuDto.getName())
                .price(menuDto.getPrice())
                .category(menuDto.getCategory()) // 카테고리 추가
                .build();

        menus.put(menuDto.getMenuId(), menu);
    }

    // READ All
    public List<MenuDTO> findAll(){
        return menus.values().stream()
                .map(menu -> MenuDTO.builder()
                        .menuId(menu.getMenuId())
                        .name(menu.getName())
                        .price(menu.getPrice())
                        .category(menu.getCategory()) // 카테고리 추가
                        .build()).toList();
    }

    // READ By Id
    public MenuDTO findById(Integer menuId) {
        Menu menu = menus.get(menuId);
        return MenuDTO.builder()
                .menuId(menu.getMenuId())
                .name(menu.getName())
                .price(menu.getPrice())
                .category(menu.getCategory())
                .build();
    }

    // UPDATE
    public void update(Integer menuId, MenuDTO menuDto){
        Menu menu = menus.get(menuId);
        menu.setName(menuDto.getName());
        menu.setPrice(menuDto.getPrice());
        menu.setCategory(menuDto.getCategory());
    }

    // DELETE
    public void delete(Integer menuId) {
        menus.remove(menuId);
    }
}
