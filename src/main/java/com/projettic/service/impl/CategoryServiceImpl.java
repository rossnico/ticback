package com.projettic.service.impl;

import com.alibaba.fastjson.JSON;
import com.projettic.dao.CategoryDao;
import com.projettic.entity.Category;
import com.projettic.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> findAll() {
        List<Category> list = categoryDao.findAllCategories();
        list.sort(new Comparator<Category>() {
            @Override
            public int compare(Category o1, Category o2) {
                return o1.getOrderCategory() - o2.getOrderCategory();
            }
        });
        return list;
    }

    @Override
    public String findById(Category category) {
        Category cat = categoryDao.findCategoryById(category.getIdCategory());
        return JSON.toJSONString(cat);
    }

    @Override
    @Transactional
    public void deleteCategoryById(int id) {
        categoryDao.deleteCategoryById(id);
    }

    @Override
    @Transactional
    public void addCategory(Category category) {
        categoryDao.addCategory(category);
    }

    @Override
    @Transactional
    public void updateCategory(Category category) {
        categoryDao.updateCategory(category);
    }
}
