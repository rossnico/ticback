package com.projettic.security;

import com.alibaba.fastjson.JSON;
import com.projettic.entity.Account;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public CustomAuthenticationFilter() {
        this.setFilterProcessesUrl("/user/login");
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authRequest = null;
//        if(request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE) || request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = reader.readLine()) != null)
                responseStrBuilder.append(inputStr);
            Account account = JSON.parseObject(responseStrBuilder.toString(), Account.class);
            authRequest = new UsernamePasswordAuthenticationToken(account.getUserName(), account.getUserPassword());
        } catch (IOException e) {
            e.printStackTrace();
            authRequest = new UsernamePasswordAuthenticationToken("", "");
        } finally {
            setDetails(request, authRequest);
            return this.getAuthenticationManager().authenticate(authRequest);
        }
//        } else {
//            return super.attemptAuthentication(request, response);
//        }

    }
}

