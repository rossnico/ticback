package com.projettic.service.impl;

import com.projettic.dao.AccountDao;
import com.projettic.entity.Account;
import com.projettic.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountDao accountDao;


    @Override
    public List<Account> findAllUser() {
        try{
            return accountDao.findAllUser();
        } catch (BadSqlGrammarException e){
            System.out.println(e.getSQLException().getErrorCode());
            return null;
        }
    }

    @Override
    public void saveAccount(Account account) {
        try{
            accountDao.saveUserAccount(account);
        } catch (BadSqlGrammarException e){
            System.out.println(e.getSQLException().getErrorCode());
        }
    }

    @Override
    public Account checkAccount(Account account) {
        Account accountDb = accountDao.isExist(account);
        if (accountDb!= null) {
            System.out.println(accountDb.toString());
            if (account.isEquals(accountDb)) {
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
}
