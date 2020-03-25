package com.projettic.config;


import com.projettic.interceptor.UserSessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] listPathExclude = {"/user/login","/user/getLogInfo","/user/errorLogin","/user/register","/user/registerInfo"};
        registry.addInterceptor(new UserSessionInterceptor()).addPathPatterns("/user/**").excludePathPatterns(listPathExclude);
        //TODO 添加Sqlexecutor,CategoryController,CorrectionController,ExerciseController拦截器


    }
}
