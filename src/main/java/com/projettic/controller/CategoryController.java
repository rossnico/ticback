package com.projettic.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.projettic.entity.Category;
import com.projettic.entity.StatusCode;
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
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path="/getCategoryById", method = RequestMethod.POST)
    @ResponseBody
    public String getById(@RequestBody String param) {
    	Category category = JSON.parseObject(param, Category.class);
    	return categoryService.findById(category);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path="/deleteCategory/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteCategory(@PathVariable  int id) {
    	categoryService.deleteCategoryById(id);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path="/addCategory", method = RequestMethod.POST)
    @ResponseBody
    public String addCategory(@RequestBody String param){
        try{
            Category category = JSON.parseObject(param, Category.class);
            categoryService.addCategory(category);
            JSONObject jsonObject = new JSONObject();
            logger.info("New category added: "+ category.toString());
            jsonObject.put("StatusCode", StatusCode.SUCCESS.getCode());
            jsonObject.put("StatusMessage", StatusCode.SUCCESS.getMessage());
            return jsonObject.toString();
        } catch(Exception e){
            JSONObject jsonObject = new JSONObject();
            logger.warn("error when add new category: "+ param.toString()+"  "+e.getMessage());
            jsonObject.put("StatusCode", StatusCode.UNSUCCESS.getCode());
            jsonObject.put("StatusMessage", StatusCode.UNSUCCESS.getMessage());
            return jsonObject.toString();
        }
    }
    
    @CrossOrigin(origins = "http://localhost:4200")   
    @RequestMapping(path="/updateCategory", method = RequestMethod.POST)
    @ResponseBody
    public void updateCategory(@RequestBody String param) {
    	Category category = JSON.parseObject(param, Category.class);
        categoryService.updateCategory(category);
    }
}
