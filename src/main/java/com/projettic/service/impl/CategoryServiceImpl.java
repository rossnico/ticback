package com.projettic.service.impl;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.projettic.dao.CategoryDao;
import com.projettic.entity.Category;
import com.projettic.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> findAll() {
    	List<Category> list = categoryDao.findAllCategories();
    	list.sort(Comparator.comparingInt(Category::getOrderCategory));
    	return list;
    }
    
    @Override
    public String findById(Category category) {
	    Category cat = categoryDao.findCategoryById(category.getIdCategory());
	    return JSON.toJSONString(cat);
    }
    
    @Override
    public void deleteCategoryById(int id) {
        categoryDao.deleteCategoryById(id);
    }

    @Override
    public void addCategory(Category category) {
        categoryDao.addCategory(category);
    }
    
    @Override
    public void updateCategory(Category category) {
        categoryDao.updateCategory(category);
    }
}


