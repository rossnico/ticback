package com.projettic.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.projettic.entity.Category;
import com.projettic.entity.StatusCode;
import com.projettic.service.impl.CategoryServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping(path = "/category")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/getAllCategories", method = RequestMethod.GET)
    @ResponseBody
    public String getAll() {
        List<Category> list = categoryService.findAll();
        return JSON.toJSONString(list);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/getCategoryById", method = RequestMethod.POST)
    @ResponseBody
    public String getById(@RequestBody String param) {
        Category category = JSON.parseObject(param, Category.class);
        return categoryService.findById(category);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/deleteCategory", method = RequestMethod.POST)
    @ResponseBody
    public void deleteCategory(@RequestBody String param) {
        try {
            Category category = JSON.parseObject(param, Category.class);
            categoryService.deleteCategoryById(category.getIdCategory());
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/addCategory", method = RequestMethod.POST)
    @ResponseBody
    public String addCategory(@RequestBody String param) {
        try {
            Category category = JSON.parseObject(param, Category.class);
            categoryService.addCategory(category);
            JSONObject jsonObject = new JSONObject();
            log.info("New category added: " + category.toString());
            jsonObject.put("StatusCode", StatusCode.SUCCESS.getCode());
            jsonObject.put("StatusMessage", StatusCode.SUCCESS.getMessage());
            return jsonObject.toString();
        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            log.warn("error when add new category: " + param + "  " + e.getMessage());
            jsonObject.put("StatusCode", StatusCode.UNSUCCESS.getCode());
            jsonObject.put("StatusMessage", StatusCode.UNSUCCESS.getMessage());
            return jsonObject.toString();
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/updateCategory", method = RequestMethod.POST)
    @ResponseBody
    public void updateCategory(@RequestBody String param) {
        try {
            Category category = JSON.parseObject(param, Category.class);
            categoryService.updateCategory(category);
        } catch (Exception e) {
            log.error(e.toString());
        }

    }


}
