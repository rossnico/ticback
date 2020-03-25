package com.projettic.dao;

import com.projettic.entity.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("categoryDao")
public interface CategoryDao {
    @Select("select * from t_category")
    @Results(id = "categoryMapper", value = {
            @Result(id=true, column = "id_category", property = "idCategory"),
            @Result(column = "name_category", property = "nameCategory"),
            @Result(column = "order_category", property = "orderCategory")
    })
    List<Category> findAllCategories();

    @Select("select * from t_category where id_category = #{id}")
    @ResultMap("categoryMapper")
    Category findCategoryById(int id);

    @Delete("delete from t_category where id_category = #{id}")
    @ResultMap("categoryMapper")
    void deleteCategoryById(int id);

    @Insert("insert into t_category(order_category, name_category)" +
            "values(#{orderCategory},#{nameCategory})")
    @ResultMap("categoryMapper")
    void addCategory(Category category);

    @Update ("UPDATE t_category set name_category = #{nameCategory}, order_category =#{orderCategory} where id_category=#{idCategory}")
    @ResultMap("categoryMapper")
    void updateCategory(Category category);
}
