package com.projettic.dao;

import com.projettic.entity.Correction;
import com.projettic.entity.Exercise;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ExerciseDao {

    @Select("select * from t_exercise")
    List<Exercise> findAllExercise();

    @Select("select * from t_exercise where idExercise = #{id}")
    Exercise findExerciseById(int id);

    @Insert("insert into t_exercise(exerciseText, exerciseCorrection, groupId) " +
            "values(#{exerciseText},#{exerciseCorrection},#{groupId})")
    void addExercise(Exercise exercise);
    
    @Select("select * from t_exercise where groupId = #{id}")
    List<Exercise> findByGroup(int id);

    @Select("select * from t_correction where idExercise = #{idExercise}")
    List<Correction> findAllCorrectionByExercise(int idExercise);
}
