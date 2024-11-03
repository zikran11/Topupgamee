/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.UcTopUpUtil;
import POJO.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author lenovo
 */
public class DAOLogin {
     public List<User> getBy(String uName, String uPass) {
        Transaction trans = null;
        User us = new User();
        List<User> user = new ArrayList();
        Session session = UcTopUpUtil.getSessionFactory().openSession();
        
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from User where username=:uName AND password=:uPass");
            query.setString("uName", uName);
            query.setString("uPass", uPass);
            us = (User) query.uniqueResult();
            user = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }
     
     public String add_user(User user){
        Transaction trans = null;
        Session session = UcTopUpUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(user);
            trans.commit();
            return "Login";
        } catch (Exception e) {
            System.out.println(e);
        }
        return "failed";
    }
}
