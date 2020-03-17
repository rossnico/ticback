package com.projettic.dao;

import com.projettic.entity.Category;
import com.projettic.entity.Exercise;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CategoryDao {
	@Select("select * from t_category")
	public List<Category> findAllCategories();
	
    @Select("select * from t_category where id = #{id}")
    public Category findCategoryById(int id);
    
    @Delete("delete from t_category where id = #{id}")
    public void deleteCategoryById(int id);
    
    @Insert("insert into t_category(id, name)" +
            "values(#{id},#{name})")
    void addCategory(Category category);  
    
    @Update ("UPDATE t_category set name = #{name} where id =#{id}")
    void updateCategory(Category category);
}
