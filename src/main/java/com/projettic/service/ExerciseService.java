package com.projettic.service;

import com.projettic.entity.Exercise;

import java.util.List;

public interface ExerciseService {
    List<Exercise> findAll();
    String findById(Exercise exercise);
    void addExercise(Exercise exercise);
}
