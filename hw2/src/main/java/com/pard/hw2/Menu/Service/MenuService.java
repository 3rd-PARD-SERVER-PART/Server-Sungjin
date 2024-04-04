package com.pard.HW2.Menu.Service;

import com.pard.HW2.Menu.DTO.MenuDTO;
import com.pard.HW2.Menu.Repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public void saveMenu(MenuDTO menuDto){
        menuRepository.save(menuDto);
    }

    public List<MenuDTO> findAllMenus(){
        return menuRepository.findAll();
    }

    public MenuDTO findMenuById(Integer menuId){
        return menuRepository.findById(menuId);
    }

    public void updateMenu(Integer menuId, MenuDTO menuDto){
        menuRepository.update(menuId, menuDto);
    }

    public void deleteMenu(Integer menuId){
        menuRepository.delete(menuId);
    }
}
