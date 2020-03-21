package com.projettic.dao;

import com.projettic.entity.Account;
import com.projettic.entity.SqlQuery;
import org.apache.ibatis.annotations.*;
import org.springframework.jdbc.BadSqlGrammarException;

import java.util.LinkedHashMap;
import java.util.List;

public interface AccountDao {

    @Select("select * from t_user")
    @Results(id = "accountMapper", value = {
            @Result(id=true, column = "user_id", property = "userId"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "user_password", property = "userPassword"),
            @Result(column = "user_email", property = "userEmail"),
            @Result(column = "user_class", property = "userClass")
    })
    List<Account> findAllUser();

    @Select("select * from t_user where user_name = #{userName}")
    @ResultMap("accountMapper")
    Account findUserByName(String userName);

    @Select("select * from t_user where user_email = #{userEmail}")
    @ResultMap("accountMapper")
    Account findUserByEmail(String email);

    @Select("select * from t_user where user_email=#{userEmail} or user_name = #{userName}")
    @ResultMap("accountMapper")
    Account isExist(Account account);

    @Insert("insert into t_user(user_name, user_password, user_email, user_class) " +
            "values(#{userName},#{userPassword},#{userEmail},#{userClass})")
    @ResultMap("accountMapper")
    void saveUserAccount(Account user);
}
