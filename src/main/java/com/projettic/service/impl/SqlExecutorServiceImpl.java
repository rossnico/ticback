package com.projettic.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.projettic.dao.CorrectionDao;
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

    @Autowired
    private CorrectionDao correctionDao;


    @Override
    public String getHisRes(SqlQuery sqlQuery){
        try {
            List<LinkedHashMap<String, Object>> empList = sqlExecutorDao.getHisResult(sqlQuery);
            JSONArray jsonArray = new JSONArray();
            for(LinkedHashMap linkedHashMap : empList){
                JSONObject jsonObject = new JSONObject(linkedHashMap);
                jsonArray.add(jsonObject);
            }
            return jsonArray.toString();
        } catch (BadSqlGrammarException e ){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("ErrorCode", e.getSQLException().getErrorCode());
            jsonObject.put("RootCause", e.getSQLException().getMessage());
            return jsonObject.toString();
        }
    }

    @Override
    public String correctSqlSyntax(SqlQuery sqlQuery) {
        List<Correction> correctionList = correctionDao.findAllCorrectionByExercise(sqlQuery.getIdExercise());
        for(Correction correction1 : correctionList){
            if(sqlQuery.getSqlQuery().equals(correction1.getTextCorrection())){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("VeriCode", VeriCode.CORRECT.getCode());
                jsonObject.put("VeriMessage", VeriCode.CORRECT.getCode());
                return jsonObject.toString();
            }
        }
        return null;
    }

    @Override
    public String correctSqlResult(SqlQuery sqlQuery) {
        return null;
    }


}
