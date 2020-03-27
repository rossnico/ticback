package com.projettic.controller;

import com.alibaba.fastjson.JSON;
import com.projettic.entity.Correction;
import com.projettic.service.impl.CorrectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/correction")
public class CorrectionController {
    @Autowired
    CorrectionServiceImpl correctionService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/getCorrectionByExercise/{idExercise}", method = RequestMethod.GET)
    @ResponseBody
    public String getExercisesByGroup(@PathVariable int idExercise) {
        //TODO log,exception
        List<Correction> list = correctionService.findAllCorrectionByExercise(idExercise);
        return JSON.toJSONString(list);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/addCorrection", method = RequestMethod.POST)
    @ResponseBody
    public String addExercise(@RequestBody String parem) {
        //TODO log,exception,return
        Correction correction = JSON.parseObject(parem, Correction.class);
        String sqlString = correction.getTextCorrection();
        sqlString = sqlString.replace(";", "");
        String sqlStringTrim = sqlString.replaceAll("\\s{1,}", " ");
        correction.setTextCorrection(sqlStringTrim);
        correctionService.addCorrection(correction);
        return null;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/updateCorrection", method = RequestMethod.POST)
    @ResponseBody
    public String updateExercise(@RequestBody String parem) {
        //TODO log,exception,return
        Correction correction = JSON.parseObject(parem, Correction.class);
        String sqlString = correction.getTextCorrection();
        sqlString = sqlString.replace(";", "");
        String sqlStringTrim = sqlString.replaceAll("\\s{1,}", " ");
        correction.setTextCorrection(sqlStringTrim);
        return null;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/updateCorrection/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteExercise(@PathVariable int idCorrection) {
        //TODO log,exception,return
        correctionService.deleteCorrectionById(idCorrection);
        return null;
    }
}
