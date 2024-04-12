package com.pard.hw3.Menu.service;

import com.pard.hw3.Menu.dto.MenuDto;
import com.pard.hw3.Menu.entity.Menu;
import com.pard.hw3.Menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public void save(MenuDto menuDto){
        Menu menu = Menu.builder()
                .menuName(menuDto.getName())
                .menuPrice(menuDto.getPrice())
                .menuCategory(menuDto.getCategory())
                .menuRating(menuDto.getRating())
                .build();
        menuRepository.save(menu);
    }

    public MenuDto findById(Long menuId){
        Menu menu = menuRepository.findById(menuId).get();
        return MenuDto.builder()
                .name(menu.getMenuName())
                .price(menu.getMenuPrice())
                .category(menu.getMenuCategory())
                .rating(menu.getMenuRating())
                .build();
    }

    public List<MenuDto> findAll(){
        List<Menu> menus = menuRepository.findAll();
        List<MenuDto> menuDtos = menus.stream()
                .map(menu -> MenuDto.builder()
                        .name(menu.getMenuName())
                        .price(menu.getMenuPrice())
                        .category(menu.getMenuCategory())
                        .rating(menu.getMenuRating())
                        .build()
        ).toList();
        return menuDtos;
    }

    public void update(Long menuId, MenuDto menuDto){
        Menu menu = menuRepository.findById(menuId).get();
        menu.setMenuName(menuDto.getName());
        menu.setMenuPrice(menuDto.getPrice());
        menu.setMenuCategory(menuDto.getCategory());
        menu.setMenuRating(menuDto.getRating());
        menuRepository.save(menu);
    }

    public void delete(Long menuId){
        menuRepository.deleteById(menuId);
    }

    public List<MenuDto> findByPriceRange(double minPrice, double maxPrice){
        List<Menu> menus = menuRepository.findByMenuPriceBetween(minPrice, maxPrice);
        List<MenuDto> menuDtos =  menus.stream().map(menu -> MenuDto.builder()
                        .name(menu.getMenuName())
                        .price(menu.getMenuPrice())
                        .category(menu.getMenuCategory())
                        .rating(menu.getMenuRating())
                        .build()
        ).toList();

        return menuDtos;
    }

    public List<MenuDto> findByCategory(String category){
        List<Menu> menus = menuRepository.findByMenuCategory(category);
        List<MenuDto> menuDtos =  menus.stream().map(menu -> MenuDto.builder()
                .name(menu.getMenuName())
                .price(menu.getMenuPrice())
                .category(menu.getMenuCategory())
                .rating(menu.getMenuRating())
                .build()
        ).toList();

        return menuDtos;
    }

    public List<MenuDto> findByRatingRange(double minRating, double maxRating){
        List<Menu> menus = menuRepository.findByMenuRatingBetween(minRating, maxRating);
        List<MenuDto> menuDtos =  menus.stream().map(menu -> MenuDto.builder()
                .name(menu.getMenuName())
                .price(menu.getMenuPrice())
                .category(menu.getMenuCategory())
                .rating(menu.getMenuRating())
                .build()
        ).toList();

        return menuDtos;
    }
}
