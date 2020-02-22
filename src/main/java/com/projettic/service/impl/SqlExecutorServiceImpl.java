package com.projettic.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.projettic.dao.SqlExecutorDao;
import com.projettic.entity.SqlQuery;
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
    public String getCorrection() {
        return null;
    }
}
