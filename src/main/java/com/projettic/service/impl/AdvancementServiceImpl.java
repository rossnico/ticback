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
            List<Advancement> list = advancementDao.findAdvancementByUserId(advancement.getAdvUserId());
            if (list.contains(advancement)) {
                System.out.println("Advancement already exists");
            } else {
                advancementDao.saveAdvancement(advancement);
            }
        } catch (BadSqlGrammarException e) {
            System.out.println(e.getSQLException().getErrorCode());
        }
    }

    public List<CategoryAdvancement> getCategoryAdvancement(int idUser) {
        return this.advancementDao.findCategoryAdvancement(idUser);
    }
}
