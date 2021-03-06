package com.projettic.service;

import com.projettic.entity.Category;
import com.projettic.entity.Correction;
import com.projettic.entity.Exercise;

import java.util.List;

public interface ExerciseService {
    List<Exercise> findAll();
    String findById(Exercise exercise);
    void addExercise(Exercise exercise);
    void deleteExerciseById(int idExercise);
    void updateExercise(Exercise exercise);
	List<Exercise> findByCate(int id);
	List<Exercise> getExercisesToDoByGroup(int idCategory, int idUser);

}
