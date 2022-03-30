package com.hungries.service.menuService.Impl;

import com.hungries.model.Menu;
import com.hungries.repository.MenuRepository;
import com.hungries.service.menuService.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    //@Autowired
    //private MenuRepository menuRepository;

    public List<Menu> getAllMenuItems() {
     // List<Menu> menuList=menuRepository.findAll();
        return null;
    }
}