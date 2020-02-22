//package com.projettic.test;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.projettic.dao.AccountDao;
//import com.projettic.entity.SqlQuery;
//import com.projettic.entity.Account;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.junit.Test;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.LinkedHashMap;
//import java.util.List;
//
//
//public class MybatisTest {
//    @Test
//    public void userLoginTest() throws IOException {
//        try{
//            InputStream in = Resources.getResourceAsStream("Mybatis/SqlMapConfig.xml");
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//            SqlSession session = factory.openSession();
//            AccountDao dao = session.getMapper(AccountDao.class);
//            List<Account> userList = dao.findAllUser();
//            for(Account user:userList){
//                System.out.println(user.toString());
//            }
//            session.close();
//            in.close();
//        } catch(Exception e){
//            System.out.println(e.getStackTrace());
//        }
//
//    }
//
//    @Test
//    public void userRegisterTest() throws IOException {
//        try{
//            InputStream in = Resources.getResourceAsStream("Mybatis/SqlMapConfig.xml");
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//            SqlSession session = factory.openSession();
//            AccountDao dao = session.getMapper(AccountDao.class);
//            Account user1 = new Account();
//            user1.setGroupid(2);
//            user1.setUsername("Toto");
//            user1.setPassword("15265");
//            user1.setEmail("dlgjslidjgl");
//
//            dao.saveUserAccount(user1);
//
//            session.commit();
//
//            List<Account> userList = dao.findAllUser();
//            for(Account user:userList){
//                System.out.println(user.toString());
//            }
//            session.close();
//            in.close();
//        } catch(Exception e){
//            System.out.println(e.getStackTrace());
//        }
//
//    }
//
//    @Test
//    public void testQuery() throws IOException {
//        try{
//            SqlQuery sqlQuery = new SqlQuery();
//            sqlQuery.setSqlQuery("select * from emp");
//            InputStream in = Resources.getResourceAsStream("Mybatis/SqlMapConfig.xml");
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//            SqlSession session = factory.openSession();
//            AccountDao dao = session.getMapper(AccountDao.class);
//            List<LinkedHashMap<String, Object>> userList = dao.testQuery(sqlQuery);
//            JSONArray jsonArray = new JSONArray();
//            for(LinkedHashMap linkedHashMap : userList){
//                JSONObject jsonObject = new JSONObject(linkedHashMap);
//                jsonArray.add(jsonObject);
//                System.out.println(jsonArray);
//            }
//            session.close();
//            in.close();
//        } catch(Exception e){
//            System.out.println(e.getStackTrace());
//        }
//
//    }
//
//
//}
