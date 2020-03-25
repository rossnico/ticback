package com.projettic.service.impl;

import com.projettic.dao.CorrectionDao;
import com.projettic.entity.Correction;
import com.projettic.service.CorrectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void addCorrection(Correction correction) {
        System.out.println(correction.getIdExercise() + correction.getTextCorrection());
        correctionDao.addCorrection(correction);
    }

    @Override
    @Transactional
    public void deleteCorrectionById(int idCorrection) {
        correctionDao.deleteCorrectionById(idCorrection);
    }

    @Override
    @Transactional
    public void updateCorrection(Correction correction) {
        correctionDao.updateCorrection(correction);
    }

}
