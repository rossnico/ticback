package com.projettic.controller;

import com.alibaba.fastjson.JSON;
import com.projettic.entity.Correction;
import com.projettic.service.impl.CorrectionServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
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
    public void addCorrection(@RequestBody String parem) {
        try {
            Correction correction = JSON.parseObject(parem, Correction.class);
            String sqlString = correction.getTextCorrection();
            sqlString = sqlString.replace(";", "");
            String sqlStringTrim = sqlString.replaceAll("\\s{1,}", " ");
            correction.setTextCorrection(sqlStringTrim);
            correctionService.addCorrection(correction);
        } catch (Exception e) {
            log.error(e.toString());
        }

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/updateCorrection", method = RequestMethod.POST)
    @ResponseBody
    public void updateCorrection(@RequestBody String parem) {
        try {
            Correction correction = JSON.parseObject(parem, Correction.class);
            String sqlString = correction.getTextCorrection();
            sqlString = sqlString.replace(";", "");
            String sqlStringTrim = sqlString.replaceAll("\\s{1,}", " ");
            correction.setTextCorrection(sqlStringTrim);
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/deleteCorrection/{idCorrection}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteCorrection(@PathVariable int idCorrection) {
        try {
            correctionService.deleteCorrectionById(idCorrection);
        } catch (Exception e) {
            log.error(e.toString());
        }
    }
}
