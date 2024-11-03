/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.util.List;
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
public class CustomerTest {
    
    public CustomerTest() {
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
  public void testGetAllRecords() {
    System.out.println("Test Get All Record");
    Customer instance = new Customer();
    int expResult = 18;
    List<Customer> result = instance.getAllRecords();
    assertEquals(expResult, result.size());
  }

  @Test
  public void testGetById() {
    System.out.println("Test Get by ID");
      
    Customer instance = new Customer();
    instance.setId(1);
    
    String expResult = "Data Customer";
    String result = instance.getById();

    assertEquals(expResult, result);
  }

  @Test
  public void testSave_Customer() {
    System.out.println("Test Save Customer");
    
    Customer instance = new Customer();
    instance.setIdGame("122214");
    instance.setPayment("OVO");
    instance.setTotal("70+3");
    instance.setPhone("0812805050");
    
     String expResult = "transaksi";
     String result = instance.save_customer();
     System.out.println(expResult);
     System.out.println(result);
     assertEquals(expResult, result);
  }

  @Test
  public void testEditCustomer() {
    System.out.println("editCustomer");
    
    Customer instance = new Customer();
    instance.setId(10);
    instance.setIdGame("122210");
    instance.setPayment("OVO");
    instance.setTotal("70+3");
    instance.setPhone("0812807090");
    
    String expResult = "Data Customer";
    String result = instance.editCustomer();

    assertEquals(expResult, result);
  }
  
  @Test
  public void testDeleteCustomer() {
    System.out.println("deleteCustomer");
    
    Customer instance = new Customer();
    instance.setId(9);
    
    String expResult = "Data Customer";
    String result = instance.deleteCustomer();
    
    assertEquals(expResult, result);
  }

}
