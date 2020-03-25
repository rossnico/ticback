package com.projettic.service;

import com.projettic.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    String findById(Category category);

    void deleteCategoryById(int id);

    void addCategory(Category category);

    void updateCategory(Category category);
}
