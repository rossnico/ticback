package com.projettic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.projettic.entity.Account;
import com.projettic.entity.AccountAdvancement;
import com.projettic.entity.Advancement;
import com.projettic.entity.CategoryAdvancement;

public interface AdvancementDao {
    @Select("select adv_user_id as userId,"
    		+ " count(*) as nbExercisesDone,"
    		+ " (count(*)*100/(select count(*) from t_exercise)) as advancementPercentage"
    		+ " from t_advancement "
    		+ "group by userId")
    List<AccountAdvancement> findAllAdvancement();
    
    @Insert("insert into t_advancement(adv_user_id, adv_category_id, adv_exercise_id) " +
            "values(#{advUserId},#{advCategoryId},#{advExerciseId})")
    void saveAdvancement(Advancement advancement);
    
    @Select("select distinct cat.id_category as idCategory, \r\n" + 
    		"cat.name_category as nameCategory, \r\n" + 
    		"cat.order_category as orderCategory,\r\n" + 
    		"(select count(*) as nbDone from t_advancement adv where adv.adv_category_id=cat.id_category and adv.adv_user_id=#{idUser} ) as nbDone,\r\n" + 
    		"(select count(*) as nbTotal from t_exercise exe where cat.id_category=exe.id_category) as nbTotal\r\n" + 
    		"from t_category cat left join t_advancement adv\r\n" + 
    		"on cat.id_category = adv.adv_category_id;")
    List<CategoryAdvancement> findCategoryAdvancement(int idUser);
}
