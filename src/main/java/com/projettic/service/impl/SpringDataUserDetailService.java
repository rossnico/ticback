//package com.projettic.service.impl;
//
//import com.projettic.dao.AccountDao;
//import com.projettic.entity.Account;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class SpringDataUserDetailService implements UserDetailsService {
//
//    @Autowired
//    AccountDao accountDao;
//
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        Account account = accountDao.findUserByNameOrEmail(s);
//        if(account == null){
//            return null;
//        }
//        UserDetails userDetails = User.withUsername(account.getUserName()).password(account.getUserPassword()).authorities(account.getUserClass()).build();
//        return userDetails;
//    }
//}
