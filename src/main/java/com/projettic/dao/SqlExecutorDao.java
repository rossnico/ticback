package com.projettic.dao;

import com.projettic.entity.Correction;
import com.projettic.entity.SqlQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
@Component("sqlExecutorDao")
public interface SqlExecutorDao {

    @Select("${sqlQuery}")
    List<LinkedHashMap<String, Object>> getResult(SqlQuery sqlQuery) throws BadSqlGrammarException;

    @Select("select * from t_correction where id_exercise = #{idExercise}")
    @Results(id = "correctionMapper", value = {
            @Result(id=true, column = "id_correction", property = "idCorrection"),
            @Result(column = "text_correction", property = "textCorrection"),
            @Result(column = "id_exercise", property = "idExercise")
    })
    List<Correction> findAllCorrectionByExercise(int idExercise);
}
