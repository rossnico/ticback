package com.projettic.service.impl;

import com.projettic.dao.CorrectionDao;
import com.projettic.entity.Correction;
import com.projettic.entity.Exercise;
import com.projettic.service.CorrectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("correctionService")
public class CorrectionServiceImpl implements CorrectionService {
    @Autowired
    CorrectionDao correctionDao;

    @Override
    public List<Correction> findAllCorrectionByExercise(int idExercise) {
        return correctionDao.findAllCorrectionByExercise(idExercise);
    }

    @Override
    public void addCorrection(Correction correction) {
        correctionDao.addCorrection(correction);
    }

    @Override
    public void deleteCorrectionById(int idCorrection) {
        correctionDao.deleteCorrectionById(idCorrection);
    }

    @Override
    public void updateCorrection(Correction correction) {
        correctionDao.updateCorrection(correction);
    }

}
