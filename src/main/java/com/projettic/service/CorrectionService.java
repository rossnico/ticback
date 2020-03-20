package com.projettic.service;

import com.projettic.entity.Correction;
import com.projettic.entity.Exercise;

import java.util.List;

public interface CorrectionService {
    List<Correction> findAllCorrectionByExercise(Exercise exercise);
    void addCorrection(Correction correction);
    void deleteCorrectionById(Correction correction);
    void updateCorrection(Correction correction);
}
