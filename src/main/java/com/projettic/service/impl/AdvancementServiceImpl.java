package com.projettic.service.impl;

import com.projettic.dao.AdvancementDao;
import com.projettic.entity.AccountAdvancement;
import com.projettic.entity.Advancement;
import com.projettic.entity.CategoryAdvancement;
import com.projettic.service.AdvancementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("advancementService")
public class AdvancementServiceImpl implements AdvancementService {

    @Autowired
    private AdvancementDao advancementDao;

    public List<AccountAdvancement> findAllAdvancement() {
        return this.advancementDao.findAllAdvancement();
    }

    @Transactional
    @Override
    public void saveAdvancement(Advancement advancement) {
        try {
            advancementDao.saveAdvancement(advancement);
        } catch (BadSqlGrammarException e) {
            System.out.println(e.getSQLException().getErrorCode());
        }
    }

    public List<CategoryAdvancement> getCategoryAdvancement(int idUser) {
        List<CategoryAdvancement> list = this.advancementDao.findCategoryAdvancement(idUser);
        System.out.println(list);
        return list;
    }
}
