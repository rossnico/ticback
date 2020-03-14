package com.projettic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    	return list;
    }
}
