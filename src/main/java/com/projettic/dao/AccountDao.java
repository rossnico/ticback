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
    List<Account> findAllUser();

    @Select("select * from t_user where username = #{username}")
    Account findUserByName(Account account);

    @Select("select * from t_user where email = #{email}")
    Account findUserByEmail(Account account);

    @Select("select * from t_user where email=#{email} or username = #{username}")
    Account isExist(Account account);

    @Insert("insert into t_user(username, password, email, groupid) " +
            "values(#{username},#{password},#{email},#{groupid})")
    void saveUserAccount(Account user);
}
