package com.projettic.dao;

import com.projettic.entity.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("accountDao")
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

    @Select("select * from t_user where user_name = #{userName} or user_name = #{userName}")
    @ResultMap("accountMapper")
    Account findUserByUserName(String userName);


    @Select("select * from t_user where user_email=#{userEmail} or user_name = #{userName}")
    @ResultMap("accountMapper")
    Account findUserByNameOrEmail(Account account);

    @Insert("insert into t_user(user_name, user_password, user_email, user_class) " +
            "values(#{userName},#{userPassword},#{userEmail},#{userClass})")
    @ResultMap("accountMapper")
    void saveUserAccount(Account user);
}
