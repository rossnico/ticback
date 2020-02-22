package com.projettic.dao;

import com.projettic.entity.Account;
import com.projettic.entity.SqlQuery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.jdbc.BadSqlGrammarException;

import java.util.LinkedHashMap;
import java.util.List;

public interface AccountDao {

    @Select("select * from t_user")
    public List<Account> findAllUser() throws BadSqlGrammarException;

    @Select("${sqlQuery}")
    public List<LinkedHashMap<String, Object>> testQuery(SqlQuery sqlQuery) throws BadSqlGrammarException;

    @Insert("insert into t_user(username, password, email, groupid) " +
            "values(#{username},#{password},#{email},#{groupid})")
    void saveUserAccount(Account user);
}
