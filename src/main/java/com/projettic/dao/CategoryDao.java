package com.projettic.dao;

import com.projettic.entity.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CategoryDao {
	@Select("select * from t_category")
	public List<Category> findAllCategories();
}
