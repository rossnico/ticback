package com.projettic.service.impl;

import com.projettic.dao.ExerciseDao;
import com.projettic.entity.Exercise;
import com.projettic.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("exerciseService")
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private ExerciseDao exerciseDao;

    @Override
    public List<Exercise> findAll() {
        return exerciseDao.findAllExercise();
    }

    @Override
    public Exercise findById(Exercise exercise) {
        return exerciseDao.findExerciseById(exercise.getIdExercise());
    }

}
