package com.projettic.service;

import com.projettic.entity.Correction;
import com.projettic.entity.Exercise;

import java.util.List;

public interface CorrectionService {
    List<Correction> findAllCorrectionByExercise(int idExercise);
    void addCorrection(Correction correction);
    void deleteCorrectionById(int idCorrection);
    void updateCorrection(Correction correction);
}
