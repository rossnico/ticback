package com.projettic.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.projettic.entity.Category;
import com.projettic.entity.Exercise;
import com.projettic.entity.StatusCode;
import com.projettic.service.impl.ExerciseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping(path = "/exercise")
public class ExerciseController {

    @Autowired
    private ExerciseServiceImpl exerciseService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/getExoById", method = RequestMethod.POST)
    @ResponseBody
    public String reqExercise(@RequestBody String param) {
        Exercise exercise = JSON.parseObject(param, Exercise.class);
        System.out.println(exercise.toString());
        return exerciseService.findById(exercise);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/addExercise", method = RequestMethod.POST)
    @ResponseBody
    public String addExercise(@RequestBody String param) {
        try {
            Exercise exercise = JSON.parseObject(param, Exercise.class);
            System.out.println(exercise.toString());
            exerciseService.addExercise(exercise);
            JSONObject jsonObject = new JSONObject();
            log.info("New exercise added: " + exercise.toString());
            jsonObject.put("StatusCode", StatusCode.SUCCESS.getCode());
            jsonObject.put("StatusMessage", StatusCode.SUCCESS.getMessage());
            return jsonObject.toString();
        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            log.warn("error when add new exercise: " + param + "  " + e.getMessage());
            jsonObject.put("StatusCode", StatusCode.UNSUCCESS.getCode());
            jsonObject.put("StatusMessage", StatusCode.UNSUCCESS.getMessage());
            return jsonObject.toString();
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/deleteExercise/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteExercise(@PathVariable int id) {
        try {
            exerciseService.deleteExerciseById(id);
        } catch (Exception e) {
            log.error(e.toString());
        }

    }

//    @CrossOrigin(origins = "http://localhost:4200")
//    @RequestMapping(path = "/getAllExercises", method = RequestMethod.GET)
//    @ResponseBody
//    public String getAll() {
//        List<Exercise> list = exerciseService.findAll();
//        return JSON.toJSONString(list);
//    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/getExercisesByGroup", method = RequestMethod.POST)
    @ResponseBody
    public String getExercisesByGroup(@RequestBody String param) {
        Category category = JSON.parseObject(param, Category.class);
        List<Exercise> list = exerciseService.findByCate(category.getIdCategory());
        return JSON.toJSONString(list);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/updateExercise", method = RequestMethod.POST)
    @ResponseBody
    public void updateExercise(@RequestBody String param) {
        try {
            Exercise exercise = JSON.parseObject(param, Exercise.class);
            exerciseService.updateExercise(exercise);
        } catch (Exception e) {
            log.error(e.toString());
        }

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/getExercisesToDoByGroup/{idCategory}/{idUser}", method = RequestMethod.GET)
    @ResponseBody
    public String getExercisesToDoByGroup(@PathVariable int idCategory, @PathVariable int idUser) {
        List<Exercise> list = exerciseService.getExercisesToDoByGroup(idCategory, idUser);
        return JSON.toJSONString(list);
    }
}
