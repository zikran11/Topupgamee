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
public class DAOAdmin {
    // untuk menampilkan data ke tabel
    public List<User> retrveUser() {
        List listUser = new ArrayList();
        Transaction transaction = null;
        Session session = UcTopUpUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from User");
            listUser = query.list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listUser;
    }
   
    
     // untuk mencari/seach data, manipulasi data seperti delete, edit, dan search
    public List<User> getbyID(String idUser) {
        User user = new User();
        List<User> listUser = new ArrayList();
        Transaction transaction = null;
        Session session = UcTopUpUtil.getSessionFactory().openSession();
        
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from User where id = :id");
            query.setString("id", idUser);
            user = (User) query.uniqueResult();
            listUser = query.list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listUser;
    }
    
    
    // untuk delete berdcasarkan id
    public void deleteUser(Integer idUser) {
        Transaction transaction = null;
        Session session = UcTopUpUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            User user = (User) session.load(User.class, new Integer(idUser));
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    // untuk edit
    public void editUser(User user) {
        Transaction transaction = null;
        Session session = UcTopUpUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
