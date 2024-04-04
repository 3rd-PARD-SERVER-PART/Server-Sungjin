package com.pard.hw2.Menu.controller;

import com.pard.hw2.Menu.Dto.MenuDto;
import com.pard.hw2.Menu.Service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class MenuController {

    private final MenuService menuService;

    @PostMapping("")
    public void save(MenuDto menuDto){
        menuService.saveMenu(menuDto);
    }

    @GetMapping("")
    public List<MenuDto> findAll(){
        return menuService.findAllMenus();
    }

    @GetMapping("/{studentId}")
    public MenuDto fundById(@PathVariable Integer Id){
        return menuService.findMenuById(Id);
    }

    @PatchMapping("/{studentId}")
    public void update(@PathVariable Integer Id, @RequestBody MenuDto userDto ){
        menuService.updateMenu(Id, userDto);
    }

    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable Integer Id){
        menuService.deleteMenu(Id);
    }
}
