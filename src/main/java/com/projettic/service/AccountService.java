package com.projettic.service;

import com.projettic.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAllUser();
    void saveAccount(Account account);
    Account checkAccount(Account account);
    boolean isExist(Account account);
	void updateUserClass(int userId);
}
