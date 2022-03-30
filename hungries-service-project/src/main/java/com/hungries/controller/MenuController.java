package com.hungries.controller;


import com.hungries.model.Menu;
import com.hungries.service.menuService.Impl.MenuServiceImpl;
import com.hungries.service.menuService.MenuService;
import com.hungries.service.user.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.List;


@RestController
public class MenuController {

    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
    @Autowired
    private MenuServiceImpl menuService;

    @GetMapping("getAllMenuItems")
    @ResponseBody
    public ResponseEntity<List<Menu>>getAllMenuItems(HttpRequest req){
        logger.info("Get all menu items::");

        return new ResponseEntity<List<Menu>>(menuService.getAllMenuItems(),HttpStatus.OK);
    }




}
