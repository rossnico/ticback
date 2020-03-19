package com.projettic.dao;

import com.projettic.entity.Correction;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CorrectionDao {
    @Select("select * from t_correction where idExercise = #{idExercise}")
    List<Correction> findAllCorrectionByExercise(int idExercise);

    @Insert("insert into t_correction(idExercise,textCorrection)" +
            "values(#{idExercise},#{textCorrection}")
    void addCorrection(Correction correction);

    @Delete("delete from t_correction where idCorrection = #{idCorrection}")
    void deleteCorrectionById(int idCorrection);

    @Update("update t_correction set correctionText = #{correctionText} where idCorrection =#{idCorrection}")
    void updateCorrection(Correction correction);
}
