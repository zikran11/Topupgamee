/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.User;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
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
public class DAOLoginTest {
    
    public DAOLoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println(" Start Test ");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println(" End Test ");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        System.out.println("\n");
    }

    /**
     * Test of getBy method, of class DAOLogin.
     */
    
    
    @Test  
    public void testGetBy() {
    System.out.println("Test Login");
    String uName = "ragilshafa";
    String uPass = "123";   
    int empty = 0;
    DAOLogin instance = new DAOLogin();
    List<User> result = instance.getBy(uName, uPass);
    System.out.println(result.toArray().length);
    assertThat(result.toArray().length, is(not(equalTo(empty))));
  }
      
     @Test
  public void testAdd_user() {
    System.out.println("Test Register");
    
    User user = new User();
    user.setUsername("Tatang");
    user.setPassword("1234");
    
    DAOLogin instance = new DAOLogin();
    String expResult = "Login";
    String result = instance.add_user(user);
    System.out.println(expResult);
    System.out.println(result);
    assertEquals(expResult, result);
    }
  }

    /**
     * Test of add_user method, of class DAOLogin.
     */
    
