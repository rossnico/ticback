package com.projettic.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.projettic.entity.Account;
import com.projettic.entity.StatusCode;
import com.projettic.service.AccountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(path = "/user")
public class AccountController {

    static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    private AccountService accountService;

    @CrossOrigin
    @RequestMapping(path = "/testLogin")
    public String userLoginTestPage() {
        return "success";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/getLogInfo", method = RequestMethod.POST)
    @ResponseBody()
    public String userLogin(@RequestBody String param, HttpServletRequest req, HttpServletResponse res) {
        Account account = JSON.parseObject(param, Account.class);
        System.out.println(account.toString());
        Account reloginAccount = accountService.checkAccount(account);
        if(reloginAccount !=null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("ErrorCode", StatusCode.SUCCESS.getCode());
            jsonObject.put("Data", reloginAccount);
            req.getSession().setAttribute("userSession", reloginAccount);
            //res.addCookie(new Cookie("userCookie", JSON.toJSONString(reloginAccount)));
            logger.info("Login - " + reloginAccount.getUsername());
            return jsonObject.toString();
        } else {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("ErrorCode", StatusCode.UNAUTHORIZED.getCode());
            jsonObject.put("ErrorMessage", StatusCode.UNAUTHORIZED.getMessage());
            logger.info("Login not success - " + account.getUsername());
            return jsonObject.toString();
        }
    }

    @RequestMapping(path = "/login")
    public String userLogin() {
        return "login";
    }

    @RequestMapping(path = "/errorLogin")
    @ResponseBody
    public String notLoginWarning() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ErrorCode", StatusCode.NOT_LOGIN.getCode());
        jsonObject.put("ErrorMessage", StatusCode.NOT_LOGIN.getMessage());
        return jsonObject.toString();
    }

    @CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(path = "/registerInfo", method = RequestMethod.POST)
    @ResponseBody
    public String userRegister(@RequestBody String param) {
        try {
            Account account = JSON.parseObject(param,Account.class);
            account.setGroupid(2);
            if(accountService.isExist(account)) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("ErrorCode", StatusCode.USER_EXIST.getCode());
                jsonObject.put("ErrorMessage", StatusCode.USER_EXIST.getMessage());
                logger.info("Register not success - Username or email have already been used");
                return jsonObject.toString();
            } else {
                accountService.saveAccount(account);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("ErrorCode", StatusCode.SUCCESS.getCode());
                jsonObject.put("Data", accountService.checkAccount(account));
                logger.info("User registered - " + jsonObject.toString());
                return jsonObject.toString();
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return e.getMessage();
        }
    }

    @RequestMapping(path = "/register")
    public String userRegisterPage() {
        return "register";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/logOut")
    public String userLogOut(HttpServletRequest req){
        Account account = (Account) req.getSession().getAttribute("userSession");
        logger.info("Log out - " + account.getUsername());
        req.getSession().removeAttribute("userSession");
        return "login";
    }
}
