package com.projettic.service.impl;

import com.projettic.dao.AccountDao;
import com.projettic.entity.Account;
import com.projettic.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountDao accountDao;


    @Override
    public List<Account> findAllUser() {
        try {
            return accountDao.findAllUser();
        } catch (BadSqlGrammarException e) {
            System.out.println(e.getSQLException().getErrorCode());
            return null;
        }
    }

    @Override
    @Transactional
    public void saveAccount(Account account) {
        try {
            accountDao.saveUserAccount(account);
        } catch (BadSqlGrammarException e) {
            System.out.println(e.getSQLException().getErrorCode());
        }
    }

    @Override
    public Account checkAccount(Account account) {
        Account accountDb = accountDao.isExist(account);
        if (accountDb!= null) {
            if (account.isEquals(accountDb)) {
                System.out.println("check account! " + accountDb.toString());
                return accountDb;
            }
        } else {
            System.out.println("Wrong user name or password!");
        }
        return null;
    }

    @Override
    public boolean isExist(Account account) {
        if(accountDao.isExist(account)!=null){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Account findUserByName(String userName) {
        return accountDao.findUserByUserName(userName);
    }

    @Override
    public void updateUserClass(int userId) {
        try{
            Account account = accountDao.findUserById(userId);

            if (account.getUserClass() == 1) {
                accountDao.updateToUser(userId);
            }
            else if (account.getUserClass() == 2) {
                accountDao.updateToAdministrator(userId);
            }
        } catch (BadSqlGrammarException e){
            System.out.println(e.getSQLException().getErrorCode());
        }
    }
}
