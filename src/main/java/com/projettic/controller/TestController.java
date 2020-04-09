package com.projettic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

    @CrossOrigin()
    @RequestMapping("/testImplementServer")
    @ResponseBody
    public String testController() {
        return "Success";
    }
}
