package com.projettic.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.projettic.dao.ExerciseDao;
import com.projettic.entity.Exercise;
import com.projettic.entity.StatusCode;
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
    	List<Exercise> list = exerciseDao.findAllExercise();
    	return list;
    }

    @Override
    public String findById(Exercise exercise) {
        Exercise exercise1;
        exercise1 = exerciseDao.findExerciseById(exercise.getIdExercise());
        JSONObject jsonObject = new JSONObject();
        if(exercise1==null){
            jsonObject.put("StatusCode", StatusCode.PARAMS_ERROR.getCode());
            jsonObject.put("StatusMessage", StatusCode.PARAMS_ERROR.getMessage());
        } else {
            jsonObject.put("StatusCode", StatusCode.SUCCESS.getCode());
            jsonObject.put("Data", exercise1);
        }
        return jsonObject.toJSONString();
    }
    
    @Override				//C'est pour return l'exercice effacé plus tard
    public String findByIdParam(int id) {
       /* Exercise exercise1;
        exercise1 = exerciseDao.findExerciseById(id);
        JSONObject jsonObject = new JSONObject();
        if(exercise1==null){
            jsonObject.put("StatusCode", StatusCode.PARAMS_ERROR.getCode());
            jsonObject.put("StatusMessage", StatusCode.PARAMS_ERROR.getMessage());
        } else {
            jsonObject.put("StatusCode", StatusCode.SUCCESS.getCode());
            jsonObject.put("Data", exercise1);
        }*/
        return null; //jsonObject.toJSONString();
    }

    @Override
    public Exercise deleteExercise(Exercise exercise) {
    	Exercise exerciseDb;
    	exerciseDb = exerciseDao.findExerciseById(exercise.getIdExercise());
    	exerciseDao.deleteExerciseById(exercise.getIdExercise());
    	return exerciseDb;
    }
    
    @Override
    public Exercise deleteExerciseById(int id) {
    	Exercise exerciseDb;
    	exerciseDb = exerciseDao.findExerciseById(id);
    	exerciseDao.deleteExerciseById(id);
    	return exerciseDb;
    }
    
    @Override
    public void deleteExercisesByGroupId(int id) {
    	exerciseDao.deleteExercisesByGroupId(id);
    }
    
    @Override
    public void addExercise(Exercise exercise) {
        exerciseDao.addExercise(exercise);
    }
    
    @Override
    public List<Exercise> findByGroup(int groupId) {
    	return exerciseDao.findByGroup(groupId);
    }

	

}
