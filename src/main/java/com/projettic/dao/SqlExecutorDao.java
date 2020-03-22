package com.projettic.dao;

import com.projettic.entity.Account;
import com.projettic.entity.SqlQuery;
import org.apache.ibatis.annotations.Select;
import org.springframework.jdbc.BadSqlGrammarException;

import java.util.LinkedHashMap;
import java.util.List;


public interface SqlExecutorDao {

    @Select("${sqlQuery}")
    List<LinkedHashMap<String, Object>> getHisResult(SqlQuery sqlQuery) throws BadSqlGrammarException;
}
