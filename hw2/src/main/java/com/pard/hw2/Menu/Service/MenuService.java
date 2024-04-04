package com.pard.hw2.Menu.Service;

import com.pard.hw2.Menu.Dto.MenuDto;
import com.pard.hw2.Menu.Repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public void saveMenu(MenuDto menuDto){
        menuRepository.save(menuDto);
    }

    public List<MenuDto> findAllMenus(){
        return menuRepository.findAll();
    }

    public MenuDto findMenuById(Integer menuId){
        return menuRepository.findById(menuId);
    }

    public void updateMenu(Integer menuId, MenuDto menuDto){
        menuRepository.update(menuId, menuDto);
    }

    public void deleteMenu(Integer menuId){
        menuRepository.delete(menuId);
    }
}
