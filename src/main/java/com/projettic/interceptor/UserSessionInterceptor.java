package com.projettic.interceptor;

import com.projettic.entity.Account;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserSessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object o) throws Exception {
        Account account = (Account) req.getSession().getAttribute("userSession");
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie:cookies){
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());
        }

        if (account == null) {
            System.out.println("用户尚未登录，将其重定向至登录页面");
            res.sendRedirect("/user/errorLogin");
            return false;
        } else {
            System.out.println(account.toString());
            System.out.println("登录成功");
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, ModelAndView mav) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, Exception excptn) throws Exception {
    }
}
