package com.projettic.config;


//import com.projettic.interceptor.AdministratorInterceptor;
//import com.projettic.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/login");
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        String[] listLoginPathExclude = {"/user/login","/user/getLogInfo","/user/errorLogin","/user/register","/user/registerInfo"};
//        String[] listAdminPath = {"/category/**","/correction/**","/exercise/**","/sqlExecutor/**"};
//
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(listLoginPathExclude);
//
//        registry.addInterceptor(new AdministratorInterceptor()).addPathPatterns(listAdminPath);
//
//
//    }
}
