package com.pard.HW2.Menu.Controller;

import com.pard.HW2.Menu.DTO.MenuDTO;
import com.pard.HW2.Menu.Service.MenuService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @PostMapping("")
    public void save(@RequestBody MenuDTO menuDto){
        logger.info("Menu will be saved: {}", menuDto);
        menuService.saveMenu(menuDto);
        logger.info("Menu saved: {}", menuDto);
    }

    @GetMapping("")
    public List<MenuDTO> findAll(){
        List<MenuDTO> allMenus = menuService.findAllMenus();
        logger.info("All menus retrieved: {}", allMenus);
        return allMenus;
    }

    @GetMapping("/{menuId}")
    public MenuDTO findById(@PathVariable Integer menuId){
        return menuService.findMenuById(menuId);
    }

    @PatchMapping("/{menuId}")
    public void update(@PathVariable Integer menuId, @RequestBody MenuDTO menuDto ){
        menuService.updateMenu(menuId, menuDto);
    }

    @DeleteMapping("/{menuId}")
    public void delete(@PathVariable Integer menuId){
        menuService.deleteMenu(menuId);
    }
}
