package com.projettic.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.projettic.entity.SqlQuery;
import com.projettic.entity.StatusCode;
import com.projettic.service.impl.SqlExecutorServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping(path = "/sqlExecutor")
public class SqlExecutorController {
    @Autowired
    private SqlExecutorServiceImpl sqlExecutorService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/testSql", method = RequestMethod.POST)
    @ResponseBody()
    public String sqlExcecutor(@RequestBody String param) {
        try {
            SqlQuery sqlQuery = JSON.parseObject(param, SqlQuery.class);
            String sqlString = sqlQuery.getSqlQuery();
            sqlString = sqlString.replace(";", "");
            String sqlStringTrim = sqlString.replaceAll("\\s{1,}", " ");
            sqlStringTrim = sqlStringTrim.toLowerCase();
            sqlQuery.setSqlQuery(sqlStringTrim);
            log.info("input sql - " + sqlQuery.toString());
            return sqlExecutorService.getSqlResult(sqlQuery);
        } catch (Exception e) {
            log.error(e.toString());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("StatusCode", StatusCode.UNSUCCESS.getCode());
            jsonObject.put("StatusMessage", StatusCode.UNSUCCESS.getMessage());
            return jsonObject.toString();
        }

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/sqlCorrector", method = RequestMethod.POST)
    @ResponseBody()
    public String sqlCorrector(@RequestBody String param) {
        try {
            SqlQuery sqlQuery = JSON.parseObject(param, SqlQuery.class);
            String sqlString = sqlQuery.getSqlQuery();
            sqlString = sqlString.replace(";", "");
            String sqlStringTrim = sqlString.replaceAll("\\s{1,}", " ");
            sqlStringTrim = sqlStringTrim.toLowerCase();
            sqlQuery.setSqlQuery(sqlStringTrim);
            System.out.println(sqlQuery.toString());
            return sqlExecutorService.correctSql(sqlQuery);
        } catch (Exception e) {
            log.error(e.toString());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("StatusCode", StatusCode.UNSUCCESS.getCode());
            jsonObject.put("StatusMessage", StatusCode.UNSUCCESS.getMessage());
            return jsonObject.toString();
        }
    }
}
