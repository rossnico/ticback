package com.projettic.controller;

import com.alibaba.fastjson.JSON;
import com.projettic.entity.SqlQuery;
import com.projettic.service.impl.SqlExecutorServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path = "/sqlExecutor")
public class SqlExecutorController {
    static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    private SqlExecutorServiceImpl sqlExecutorService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/testSql", method = RequestMethod.POST)
    @ResponseBody()
    public String sqlExcecutor(@RequestBody String param) {
        SqlQuery sqlQuery = JSON.parseObject(param, SqlQuery.class);
        String sqlString = sqlQuery.getSqlQuery();
        sqlString = sqlString.replace(";", "");
        String sqlStringTrim = sqlString.replaceAll("\\s{1,}", " ");
        sqlStringTrim = sqlStringTrim.toLowerCase();
        sqlQuery.setSqlQuery(sqlStringTrim);
        logger.info("input sql - " + sqlQuery.toString());
        String hisRes = sqlExecutorService.getSqlResult(sqlQuery);
        return hisRes;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/sqlCorrector", method = RequestMethod.POST)
    @ResponseBody()
    public String sqlCorrector(@RequestBody String param){
        SqlQuery sqlQuery = JSON.parseObject(param, SqlQuery.class);
        String sqlString = sqlQuery.getSqlQuery();
        sqlString = sqlString.replace(";", "");
        String sqlStringTrim = sqlString.replaceAll("\\s{1,}", " ");
        sqlStringTrim = sqlStringTrim.toLowerCase();
        sqlQuery.setSqlQuery(sqlStringTrim);
        System.out.println(sqlQuery.toString());
        return sqlExecutorService.correctSql(sqlQuery);
    }
}
