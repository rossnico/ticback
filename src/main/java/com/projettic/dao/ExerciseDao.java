package com.projettic.dao;

import com.projettic.entity.Correction;
import com.projettic.entity.Exercise;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ExerciseDao {

    @Select("select * from t_exercise")
    List<Exercise> findAllExercise();

    @Select("select * from t_exercise where idExercise = #{id}")
    Exercise findExerciseById(int id);

    @Insert("insert into t_exercise(exerciseText, groupId) " +
            "values(#{exerciseText},#{groupId})")
    void addExercise(Exercise exercise);

    @Delete("delete from t_exercise where idExercise = #{idExercise}")
    void deleteExerciseById(int idExercise);

    @Update("update t_exercise set exerciseText = #{exerciseText} where idExercise =#{idExercise}")
    void updateExercise(Exercise exercise);
    
    @Select("select * from t_exercise where groupId = #{id}")
    List<Exercise> findByCate(int idCate);


}
