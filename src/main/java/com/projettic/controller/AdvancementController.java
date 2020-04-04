package com.projettic.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.projettic.entity.Account;
import com.projettic.entity.AccountAdvancement;
import com.projettic.entity.Advancement;
import com.projettic.entity.CategoryAdvancement;
import com.projettic.entity.StatusCode;
import com.projettic.service.AccountService;
import com.projettic.service.AdvancementService;

@Controller
@RequestMapping(path = "/advancement")
public class AdvancementController {
	
    @Autowired
    private AdvancementService advancementService;

	
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/getTotalAdvancement", method = RequestMethod.GET)
    @ResponseBody()
    public String getTotalAdvancement() {
    	List<AccountAdvancement> list = new ArrayList();
    	list = this.advancementService.findAllAdvancement();
    	return JSON.toJSONString(list);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/addAdvancement", method = RequestMethod.POST)
    @ResponseBody()
    public void addAdvancement(@RequestBody String param) {
    	System.out.println(param+"coucoulol");
    	Advancement advancement=JSON.parseObject(param, Advancement.class);
    	
    	this.advancementService.saveAdvancement(advancement);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/getCategoryAdvancement/{idUser}", method = RequestMethod.GET)
    @ResponseBody()
    public String getCategoryAdvancement(@PathVariable int idUser) {
    	List<CategoryAdvancement> list = this.advancementService.getCategoryAdvancement(idUser);
    	return JSON.toJSONString(list);
    }
}
