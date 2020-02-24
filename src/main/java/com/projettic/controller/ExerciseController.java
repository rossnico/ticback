package com.projettic.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.projettic.entity.Exercise;
import com.projettic.entity.StatusCode;
import com.projettic.service.impl.ExerciseServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/exercise")
public class ExerciseController {

    static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    private ExerciseServiceImpl exerciseService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path="/getExoById", method = RequestMethod.POST)
    @ResponseBody
    public String reqExercise(@RequestBody String param){
        Exercise exercise = JSON.parseObject(param, Exercise.class);
        return exerciseService.findById(exercise);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path="addExercise", method = RequestMethod.POST)
    @ResponseBody
    public String addExercise(@RequestBody String param){
        try{
            Exercise exercise = JSON.parseObject(param, Exercise.class);
            exerciseService.addExercise(exercise);
            JSONObject jsonObject = new JSONObject();
            logger.info("New exercise added: "+ exercise.toString());
            jsonObject.put("ErrorCode", StatusCode.SUCCESS.getCode());
            jsonObject.put("ErrorMessage", StatusCode.SUCCESS.getMessage());
            return jsonObject.toString();
        } catch(Exception e){
            JSONObject jsonObject = new JSONObject();
            logger.warn("error when add new exercise: "+ param.toString()+"  "+e.getMessage());
            jsonObject.put("ErrorCode", StatusCode.UNSUCCESS.getCode());
            jsonObject.put("ErrorMessage", StatusCode.UNSUCCESS.getMessage());
            return jsonObject.toString();
        }

    }
}
