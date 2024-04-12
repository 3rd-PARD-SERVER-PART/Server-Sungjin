package com.pard.hw3.Menu.controller;


import com.pard.hw3.Menu.dto.MenuDto;
import com.pard.hw3.Menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    @PostMapping("")
    public void save(@RequestBody MenuDto menuDto){
        menuService.save(menuDto);
    }

    @GetMapping("/{menuId}")
    public MenuDto findById(@PathVariable Long menuId){
        return menuService.findById(menuId);
    }

    @GetMapping("")
    public List<MenuDto> findAll(){
        return menuService.findAll();
    }

    @PatchMapping("/{menuId}")
    public void update(@PathVariable Long menuId, @RequestBody MenuDto menuDto){
        menuService.update(menuId, menuDto);
    }

    @DeleteMapping("/{menuId}")
    public void delete(@PathVariable Long menuId){
        menuService.delete(menuId);
    }

    @GetMapping("/byPriceRange")
    public List<MenuDto> findByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice){
        return menuService.findByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/byCategory")
    public List<MenuDto> findByCategory(@RequestParam String category){
        return menuService.findByCategory(category);
    }

    @GetMapping("/byRatingRange")
    public List<MenuDto> findByRatingRange(@RequestParam double minRating, @RequestParam double maxRating){
        return menuService.findByRatingRange(minRating, maxRating);
    }


}
