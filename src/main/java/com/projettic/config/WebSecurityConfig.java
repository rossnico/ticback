package com.projettic.config;

import com.alibaba.fastjson.JSONObject;
import com.projettic.entity.StatusCode;
import com.projettic.security.CustomAuthenticationFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.PrintWriter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        String[] listLoginPathExclude = {"/user/errorLogin", "/user/register", "/user/registerInfo", "/user/getSessionInfo", "/advancement/**"};
        String[] listAdminPath = {"/category/**", "/correction/**", "/exercise/**", "/user/**"};
        String[] listUserPermitPath = {
                "/category/getAllCategories",
                "/category/getCategoryById",
                "/correction/getCorrectionByExercise/**",
                "/exercise/getExoById",
                "/exercise/getExercisesByGroup",
                "/exercise/getExercisesToDoByGroup/**/**",
                "/sqlExecutor/testsql",
                "/sqlExecutor/sqlcorrector"};
        httpSecurity.authorizeRequests()
                .antMatchers(listLoginPathExclude).permitAll()
                .antMatchers(listUserPermitPath).hasAnyAuthority("2", "1")
                .antMatchers(listAdminPath).hasAuthority("1")
                .and().formLogin().loginPage("/user/login").permitAll()
                .and().csrf().disable()
                .logout().logoutUrl("/user/logout").deleteCookies("JSESSIONID").permitAll();
        httpSecurity.addFilterAt(customAuthenticationFilter(), CustomAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
        filter.setAuthenticationSuccessHandler((httpServletRequest, httpServletResponse, authentication) -> {
            httpServletResponse.setContentType("application/json;charset=utf-8");
            httpServletRequest.getRequestDispatcher("/user/login-success").forward(httpServletRequest, httpServletResponse);
        });
        filter.setAuthenticationFailureHandler((httpServletRequest, httpServletResponse, e) -> {
            httpServletResponse.setContentType("application/json;charset=utf-8");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("StatusCode", StatusCode.UNAUTHORIZED.getCode());
            jsonObject.put("StatusMessage", StatusCode.UNAUTHORIZED.getMessage());
            PrintWriter out = httpServletResponse.getWriter();
            out.write(jsonObject.toString());
            out.flush();
            out.close();
        });
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }
}
