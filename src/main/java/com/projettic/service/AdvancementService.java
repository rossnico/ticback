package com.projettic.service;

import java.util.List;

import com.projettic.entity.AccountAdvancement;
import com.projettic.entity.Advancement;
import com.projettic.entity.CategoryAdvancement;

public interface AdvancementService {
	public  List<AccountAdvancement> findAllAdvancement();
	public void saveAdvancement(Advancement advancement);
	public List<CategoryAdvancement> getCategoryAdvancement(int idUser);
	public AccountAdvancement findAdvancementByUser(int idUser);
}
