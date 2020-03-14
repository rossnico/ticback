package com.projettic.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.projettic.entity.Category;
import com.projettic.entity.Exercise;
import com.projettic.service.impl.CategoryServiceImpl;

@Controller
@RequestMapping(path="/category")
public class CategoryController {
    static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    private CategoryServiceImpl categoryService;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path="/getAllCategories", method = RequestMethod.GET)
    @ResponseBody
    public String getAll(){
    	List<Category> list = categoryService.findAll();
    	return JSON.toJSONString(list);
    }
}
