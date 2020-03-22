package com.projettic.dao;

import com.projettic.entity.Correction;
import com.projettic.entity.Exercise;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ExerciseDao {

    @Select("select * from t_exercise")
    @Results(id = "exerciseMapper", value = {
            @Result(id=true, column = "id_exercise", property = "idExercise"),
            @Result(column = "text_exercise", property = "textExercise"),
            @Result(column = "id_category", property = "idCategory")
    })
    List<Exercise> findAllExercise();

    @Select("select * from t_exercise where id_exercise = #{id}")
    @ResultMap("exerciseMapper")
    Exercise findExerciseById(int id);

    @Insert("insert into t_exercise(text_exercise, id_category) " +
            "values(#{textExercise},#{idCategory})")
    @ResultMap("exerciseMapper")
    void addExercise(Exercise exercise);

    @Delete("delete from t_exercise where id_exercise = #{idExercise}")
    void deleteExerciseById(int idExercise);

    @Update("update t_exercise set text_exercise = #{textExercise} where id_exercise =#{idExercise}")
    @ResultMap("exerciseMapper")
    void updateExercise(Exercise exercise);
    
    @Select("select * from t_exercise where id_category = #{idCate}")
    @ResultMap("exerciseMapper")
    List<Exercise> findByCate(int idCate);


}
