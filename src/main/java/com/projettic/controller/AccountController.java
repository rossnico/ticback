package com.projettic.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.projettic.entity.Account;
import com.projettic.entity.StatusCode;
import com.projettic.service.AccountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.rmi.transport.ObjectTable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class AccountController {

    static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    private AccountService accountService;

    @CrossOrigin
    @RequestMapping(path = "/testLogin", method = RequestMethod.GET)
    public String userLoginTestPage() {
        return "success";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/getUserInfo", method = RequestMethod.GET)
    @ResponseBody()
    public String getUserInfo(HttpServletRequest req) {
        Account reloginAccount = (Account) req.getSession().getAttribute("userSession");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("StatusCode", StatusCode.SUCCESS.getCode());
        jsonObject.put("Data", reloginAccount);
        return jsonObject.toString();
    }



//    @CrossOrigin(origins = "http://localhost:4200")
//    @RequestMapping(path = "/getLogInfo", method = RequestMethod.POST)
//    @ResponseBody()
//    public String userLogin(@RequestBody String param, HttpServletRequest req, HttpServletResponse res, HttpSession session) {
//        Account account = JSON.parseObject(param, Account.class);
//        account.setUserEmail(account.getUserName());
//        System.out.println(account.toString());
//        Account reloginAccount = accountService.checkAccount(account);
//        if(reloginAccount !=null) {
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("StatusCode", StatusCode.SUCCESS.getCode());
//            jsonObject.put("Data", reloginAccount);
//            session.setAttribute("userSession", reloginAccount);
//            //res.addCookie(new Cookie("userCookie", JSON.toJSONString(reloginAccount)));
//            logger.info("Login - " + reloginAccount.getUserName());
//            //System.out.println(req.getSession().getAttribute("userSession").toString());
//            return jsonObject.toString();
//        } else {
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("StatusCode", StatusCode.UNAUTHORIZED.getCode());
//            jsonObject.put("StatusMessage", StatusCode.UNAUTHORIZED.getMessage());
//            logger.info("Login not success - " + account.getUserName());
//            return jsonObject.toString();
//        }
//    }

//    @RequestMapping(path = "/login")
//    public String userLogin() {
//        return "login";
//    }

    @CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(path = "/login-success", method = RequestMethod.POST)
    @ResponseBody
    public String loginSuccess() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getDetails());
        System.out.println(authentication.getAuthorities());
        Object principal = authentication.getPrincipal();
        UserDetails userDetails = (UserDetails) principal;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("StatusCode", StatusCode.SUCCESS.getCode());
        jsonObject.put("Data", accountService.findUserByName(userDetails.getUsername()));
        return jsonObject.toString();
    }

    @CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(path = "/logout-success", method = RequestMethod.POST)
    @ResponseBody
    public String logoutSuccess() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("StatusCode", StatusCode.SUCCESS.getCode());
        return jsonObject.toString();
    }

//    @RequestMapping(path = "/login")
//    public String userLogin() {
//        return "login";
//    }

    @RequestMapping(path = "/errorLogin")
    @ResponseBody
    public String notLoginWarning() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("StatusCode", StatusCode.NOT_LOGIN.getCode());
        jsonObject.put("StatusMessage", StatusCode.NOT_LOGIN.getMessage());
        return jsonObject.toString();
    }

    @CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(path = "/registerInfo", method = RequestMethod.POST)
    @ResponseBody
    public String userRegister(@RequestBody String param) {
        try {
            Account account = JSON.parseObject(param,Account.class);
            account.setUserClass(2);
            if(accountService.isExist(account)) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("StatusCode", StatusCode.USER_EXIST.getCode());
                jsonObject.put("StatusMessage", StatusCode.USER_EXIST.getMessage());
                logger.info("Register not success - Username or email have already been used");
                return jsonObject.toString();
            } else {
                accountService.saveAccount(account);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("StatusCode", StatusCode.SUCCESS.getCode());
                jsonObject.put("Data", accountService.checkAccount(account));
                logger.info("User registered - " + jsonObject.toString());
                return jsonObject.toString();
            }
        } catch (Exception e) {
            logger.error(e.toString());
            return e.getMessage();
        }
    }

    @RequestMapping(path = "/register")
    public String userRegisterPage() {
        return "register";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/getSessionInfo",method = RequestMethod.GET)
    @ResponseBody
    public String userAuth(HttpServletRequest req) {
        JSONObject jsonObject = new JSONObject();
        if (req.getSession().getId().isEmpty()){
        	jsonObject.put("LoginStatus","false");
            return jsonObject.toString();
        }else
        	jsonObject.put("LoginStatus","true");
            jsonObject.put("Data",req.getSession().getAttribute("userSession"));
            return jsonObject.toString();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/logOut")
    public String userLogOut(HttpServletRequest req){
        Account account = (Account) req.getSession().getAttribute("userSession");
        logger.info("Log out - " + account.getUserName());
        req.getSession().removeAttribute("userSession");
        return "login";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/updateUserClass/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String updateUserClass(@PathVariable int id) {
    	accountService.updateUserClass(id);
        return null;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/getAllUsers", method = RequestMethod.GET)
    @ResponseBody
    public String getAllUsers() {
    	List<Account> list = accountService.findAllUser();
    	return JSON.toJSONString(list);
    }

}
