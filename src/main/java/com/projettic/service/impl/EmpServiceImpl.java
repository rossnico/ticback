package com.projettic.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.projettic.dao.EmpDao;
import com.projettic.entity.SqlQuery;
import com.projettic.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service("empService")
public class EmpServiceImpl implements com.projettic.service.EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    public String getHisRes(SqlQuery sqlQuery){
        try {
            List<LinkedHashMap<String, Object>> empList = empDao.getHisResult(sqlQuery);
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
