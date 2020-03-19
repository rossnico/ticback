package com.projettic.service;

import java.util.List;

import com.projettic.entity.Category;

public interface CategoryService {
	List<Category> findAll();
	String findById(Category category);
	void deleteCategoryById(Category category);
	public void addCategory(Category category);
	void updateCategory(Category category);
}
