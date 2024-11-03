/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Customer;
import POJO.UcTopUpUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lenovo
 */
public class DAOCustomerTest {
    
    public DAOCustomerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void retrveCustomer() {
    System.out.println("Test List Customer");
    DAOCustomer instance = new DAOCustomer();
    List<Customer> result = instance.retrveCustomer();
    System.out.println("Total Customer: " + result.toArray().length);
    assertFalse(result.isEmpty());
    }
    @Test
    public void testAdd_customer() {
    System.out.println("Test Create Customer");
    
    Customer customer = new Customer();
    customer.setIdGame("122204");
    customer.setPayment("OVO");
    customer.setTotal("70+3");
    customer.setPhone("0812805050");
    
     DAOCustomer instance = new DAOCustomer();
    String expResult = "transaksi";
    String result = instance.add_customer(customer);
    System.out.println(expResult);
    System.out.println(result);
    assertEquals(expResult, result);
    }
    @Test
    public void testGetbyID() {
      System.out.println("Test Search by ID");
      String idCustomer = "3";
      DAOCustomer instance = new DAOCustomer();
      List<Customer> result = instance.getbyID(idCustomer);
      assertFalse(result.isEmpty());
    }
    @Test
    public void testDeleteCustomer() {
       System.out.println("Test Delete Customer");
    
    Integer idCustomer = 10;
    DAOCustomer instance = new DAOCustomer(); 
    Transaction transaction = null;
    Session session = UcTopUpUtil.getSessionFactory().openSession();
    
    transaction = session.beginTransaction();
    instance.deleteCustomer(idCustomer);
    transaction.commit();
    
    Customer deleteCustomer = (Customer) session.get(Customer.class, idCustomer);
    assertNull(deleteCustomer);
    }

    @Test
    public void testEditCustomer() {
        System.out.println("Test Update Customer");
    
    DAOCustomer instance = new DAOCustomer();
    Transaction transaction = null;
    Session session = UcTopUpUtil.getSessionFactory().openSession();
    
    Integer id = 5;
     Customer customer = new Customer();
    customer.setIdGame("122214");
    customer.setPayment("OVO");
    customer.setTotal("70+3");
    customer.setPhone("0812805050");
    
    transaction = session.beginTransaction();
    instance.editCustomer(customer);
    transaction.commit();
    
    Customer updatedCustomer = (Customer) session.get(Customer.class, id);
    
    String expResult = "122214";
    String result = updatedCustomer.getIdGame();
    
    assertEquals(expResult, result);
    }
    
}
