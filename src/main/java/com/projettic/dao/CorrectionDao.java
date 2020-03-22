package com.projettic.dao;

import com.projettic.entity.Correction;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CorrectionDao {
    @Select("select * from t_correction where id_exercise = #{idExercise}")
    @Results(id = "correctionMapper", value = {
            @Result(id=true, column = "id_correction", property = "idCorrection"),
            @Result(column = "text_correction", property = "textCorrection"),
            @Result(column = "id_exercise", property = "idExercise")
    })
    List<Correction> findAllCorrectionByExercise(int idExercise);

    @Insert("insert into t_correction(id_exercise,text_correction)" +
            "values(#{idExercise},#{textCorrection}")
    @ResultMap("correctionMapper")
    void addCorrection(Correction correction);

    @Delete("delete from t_correction where id_correction = #{idCorrection}")
    @ResultMap("correctionMapper")
    void deleteCorrectionById(int idCorrection);

    @Update("update t_correction set text_correction = #{textCorrection} where id_correction =#{idCorrection}")
    @ResultMap("correctionMapper")
    void updateCorrection(Correction correction);
}
