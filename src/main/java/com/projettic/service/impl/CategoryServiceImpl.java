package com.projettic.service.impl;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.projettic.dao.CategoryDao;
import com.projettic.entity.Category;
import com.projettic.entity.Exercise;
import com.projettic.service.CategoryService;
import com.projettic.service.ExerciseService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;
    
    @Autowired
    private ExerciseService exerciseService;
    
    @Override
    public List<Category> findAll() {
    	List<Category> list = categoryDao.findAllCategories();
    	list.sort(new ComparatorImpl());
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
    	exerciseService.deleteExercisesByGroupId(id);
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

class ComparatorImpl implements Comparator<Category> 
{ 
    public int compare(Category a, Category b) 
    { 
        return a.getOrderCategory() - b.getOrderCategory(); 
    } 
} 
