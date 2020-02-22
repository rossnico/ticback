package com.projettic.dao;

import com.projettic.entity.Exercise;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ExerciseDao {

    @Select("select * from t_exercise")
    public List<Exercise> findAllExercise();

    @Select("select * from t_exercise where idExercise = #{id}")
    public Exercise findExerciseById(int id);
}
