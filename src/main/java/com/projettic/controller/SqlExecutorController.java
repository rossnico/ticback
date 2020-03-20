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
    private SqlExecutorServiceImpl empServiceImpl;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/testSql", method = RequestMethod.POST)
    @ResponseBody()
    public String testsql1(@RequestBody String param) {
        SqlQuery sqlQuery = JSON.parseObject(param, SqlQuery.class);
        String sqlString = sqlQuery.getSqlQuery();
        sqlString = sqlString.replace(";","");
        String sqlStringTrim = sqlString.replaceAll("\\s{1,}", " ");
        sqlStringTrim = sqlStringTrim.toLowerCase();
        System.out.println(sqlStringTrim);
        sqlQuery.setSqlQuery(sqlStringTrim);
        logger.info("input - " + sqlQuery.toString());
        String hisRes = empServiceImpl.getHisRes(sqlQuery);
        return hisRes;
    }
}
