/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Customer;
import POJO.UcTopUpUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author lenovo
 */
public class DAOCustomer {
    
    // untuk menampilkan data ke tabel
    public List<Customer> retrveCustomer() {
        List listCustomer = new ArrayList();
        Transaction transaction = null;
        Session session = UcTopUpUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Customer");
            listCustomer = query.list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listCustomer;
    }
    
     public String add_customer(Customer customer){
        Transaction trans = null;
        Session session = UcTopUpUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(customer);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return "transaksi";
    }
    
     // untuk mencari/seach data, manipulasi data seperti delete, edit, dan search
    public List<Customer> getbyID(String idCustomer) {
        Customer cust = new Customer();
        List<Customer> listCustomer = new ArrayList();
        Transaction transaction = null;
        Session session = UcTopUpUtil.getSessionFactory().openSession();
        
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Customer where id=:id");
            query.setString("id", idCustomer);
            cust = (Customer) query.uniqueResult();
            listCustomer = query.list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listCustomer;
    }
    
    // untuk delete berdcasarkan id
    public void deleteCustomer(Integer idCustomer) {
        Transaction transaction = null;
        Session session = UcTopUpUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Customer cust = (Customer) session.load(Customer.class, new Integer(idCustomer));
            session.delete(cust);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    // untuk edit
    public void editCustomer(Customer customer) {
        Transaction transaction = null;
        Session session = UcTopUpUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(customer);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

