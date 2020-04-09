package com.projettic.controller;

import com.alibaba.fastjson.JSON;
import com.projettic.entity.Advancement;
import com.projettic.entity.CategoryAdvancement;
import com.projettic.service.AdvancementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping(path = "/advancement")
public class AdvancementController {

    @Autowired
    private AdvancementService advancementService;


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/getTotalAdvancement", method = RequestMethod.GET)
    @ResponseBody()
    public String getTotalAdvancement() {
        return JSON.toJSONString(this.advancementService.findAllAdvancement());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/addAdvancement", method = RequestMethod.POST)
    @ResponseBody()
    public void addAdvancement(@RequestBody String param) {
        try {
//            System.out.println(param + "coucoulol");
            Advancement advancement = JSON.parseObject(param, Advancement.class);
            this.advancementService.saveAdvancement(advancement);
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/getCategoryAdvancement/{idUser}", method = RequestMethod.GET)
    @ResponseBody()
    public String getCategoryAdvancement(@PathVariable int idUser) {
        List<CategoryAdvancement> list = this.advancementService.getCategoryAdvancement(idUser);
        return JSON.toJSONString(list);
    }
}
