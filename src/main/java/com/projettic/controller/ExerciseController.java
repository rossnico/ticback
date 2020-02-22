package com.projettic.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.projettic.entity.Exercise;
import com.projettic.entity.StatusCode;
import com.projettic.service.impl.ExerciseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/exercise")
public class ExerciseController {

    @Autowired
    private ExerciseServiceImpl exerciseService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path="/getExoById")
    @ResponseBody
    public String reqExercise(@RequestBody String param){
        Exercise exercise = JSON.parseObject(param, Exercise.class);
        exercise = exerciseService.findById(exercise);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ErrorCode", StatusCode.SUCCESS.getCode());
        jsonObject.put("Data", exercise);
        return jsonObject.toJSONString();
    }
}
