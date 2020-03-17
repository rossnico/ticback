package com.projettic.dao;

import com.projettic.entity.Exercise;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ExerciseDao {

    @Select("select * from t_exercise")
    public List<Exercise> findAllExercise();

    @Select("select * from t_exercise where idExercise = #{id}")
    public Exercise findExerciseById(int id);

    @Insert("insert into t_exercise(exerciseText, exerciseCorrection, groupId) " +
            "values(#{exerciseText},#{exerciseCorrection},#{groupId})")
    void addExercise(Exercise exercise);
    
    @Select("select * from t_exercise where groupId = #{id}")
    public List<Exercise> findByGroup(int id);
    
    @Delete("delete from t_exercise where idExercise = #{id}")
    void deleteExerciseById(int id);
    
    @Delete("delete from t_exercise where groupId = #{id}")
    void deleteExercisesByGroupId(int id);
}
