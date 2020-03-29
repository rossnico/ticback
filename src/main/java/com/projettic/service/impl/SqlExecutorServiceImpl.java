package com.projettic.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.projettic.dao.SqlExecutorDao;
import com.projettic.entity.Correction;
import com.projettic.entity.SqlQuery;
import com.projettic.entity.VeriCode;
import com.projettic.service.SqlExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service("empService")
public class SqlExecutorServiceImpl implements SqlExecutorService {

    @Autowired
    private SqlExecutorDao sqlExecutorDao;



    @Override
    public String getSqlResult(SqlQuery sqlQuery) {
        try {
            List<LinkedHashMap<String, Object>> empList = sqlExecutorDao.getResult(sqlQuery);
            JSONArray jsonArray = new JSONArray();
            for (LinkedHashMap linkedHashMap : empList) {
                JSONObject jsonObject = new JSONObject(linkedHashMap);
                jsonArray.add(jsonObject);
            }
            return jsonArray.toString();
        } catch (BadSqlGrammarException e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("ErrorCode", e.getSQLException().getErrorCode());
            jsonObject.put("RootCause", e.getSQLException().getMessage());
            return jsonObject.toString();
        }
    }

    @Override
    public String correctSql(SqlQuery sqlQuery) {
        List<Correction> correctionList = sqlExecutorDao.findAllCorrectionByExercise(sqlQuery.getIdExercise());
        System.out.println(correctionList+"lol");
        for (Correction correction1 : correctionList) {
            if (sqlQuery.getSqlQuery().equals(correction1.getTextCorrection())) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("VeriCode", VeriCode.CORRECT.getCode());
                jsonObject.put("VeriMessage", VeriCode.CORRECT.getMessage());
                return jsonObject.toString();
            }
        }
        try {
            if (sqlExecutorDao.getResult(sqlQuery).toString().equals(sqlExecutorDao.getResult(new SqlQuery(sqlQuery.getIdExercise(), correctionList.get(0).getTextCorrection())).toString())) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("VeriCode", VeriCode.UNDETERMINED.getCode());
                jsonObject.put("VeriMessage", VeriCode.UNDETERMINED.getMessage());
                return jsonObject.toString();
            } else {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("VeriCode", VeriCode.FAULT.getCode());
                jsonObject.put("VeriMessage", VeriCode.FAULT.getMessage());
                return jsonObject.toString();
            }
        } catch (BadSqlGrammarException e) {
            //TODO log
            System.out.println(e.getSQLException());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("VeriCode", VeriCode.FAULT.getCode());
            jsonObject.put("VeriMessage", VeriCode.FAULT.getMessage());
            return jsonObject.toString();
        }
    }


}
