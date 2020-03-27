package com.projettic.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.projettic.entity.Category;
import com.projettic.entity.StatusCode;
import com.projettic.service.impl.CategoryServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/category")
public class CategoryController {
    static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    private ExerciseController exerciseController;

    @Autowired
    private CategoryServiceImpl categoryService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/getAllCategories", method = RequestMethod.GET)
    @ResponseBody
    public String getAll() {
        System.out.println("Category被请求");
        List<Category> list = categoryService.findAll();
        return JSON.toJSONString(list);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/getCategoryById", method = RequestMethod.POST)
    @ResponseBody
    public String getById(@RequestBody String param) {
        //TODO log, exception

        Category category = JSON.parseObject(param, Category.class);
        return categoryService.findById(category);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/deleteCategory", method = RequestMethod.POST)
    @ResponseBody
    public String deleteCategory(@RequestBody String param) {
        //TODO log, exception
        Category category = JSON.parseObject(param, Category.class);
        categoryService.deleteCategoryById(category.getIdCategory());
        return null;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/addCategory", method = RequestMethod.POST)
    @ResponseBody
    public String addCategory(@RequestBody String param) {
        try {
            Category category = JSON.parseObject(param, Category.class);
            categoryService.addCategory(category);
            JSONObject jsonObject = new JSONObject();
            logger.info("New category added: " + category.toString());
            jsonObject.put("StatusCode", StatusCode.SUCCESS.getCode());
            jsonObject.put("StatusMessage", StatusCode.SUCCESS.getMessage());
            return jsonObject.toString();
        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            logger.warn("error when add new category: " + param + "  " + e.getMessage());
            jsonObject.put("StatusCode", StatusCode.UNSUCCESS.getCode());
            jsonObject.put("StatusMessage", StatusCode.UNSUCCESS.getMessage());
            return jsonObject.toString();
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/updateCategory", method = RequestMethod.POST)
    @ResponseBody
    public String updateCategory(@RequestBody String param) {
        //TODO log, exception
        Category category = JSON.parseObject(param, Category.class);
        categoryService.updateCategory(category);
        return null;
    }


}
