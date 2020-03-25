package com.projettic;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.projettic.dao")
@EnableTransactionManagement(proxyTargetClass = true)
public class projetticApplication {

    public static void main(String[] args) {
        SpringApplication.run(projetticApplication.class, args);
    }
}
