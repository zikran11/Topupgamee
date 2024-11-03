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
public class UserTest {
    
    public UserTest() {
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
    User instance = new User();
    int expResult = 20;
    List<User> result = instance.getAllRecords();
    }
    @Test
    public void testGetbyID() {
        System.out.println(" Test getbyID");
        User instance = new User();
        instance.setId(1);
        String expResult = "dashboard";
        String result = instance.getbyID();
        assertEquals(expResult, result);
    }
    @Test
    public void testSave_user() {
        System.out.println("save_user");
        User instance = new User();
        instance.setUsername("Salwa");
        instance.setPassword("1020");
        
        String expResult = "Login";
        String result = instance.save_user();
        System.out.println(expResult);
        System.out.println(result);
        assertEquals(expResult, result);
    }
    @Test
    public void testLogin_user() {
        System.out.println(" Test login_user");
        User instance = new User();
        instance.setUsername("sha");
        instance.setPassword("1812"); 
    
        String expResult = "dashboard";
        String result = instance.login_user();
        System.out.println(expResult);
        System.out.println(result);
        assertEquals(expResult, result);
    }
    @Test
    public void testEditUser() {
        System.out.println(" Test editUser ");
        User instance = new User();
        instance.setId(4);
        instance.setUsername("Surya");
        instance.setPassword("kusuka");
    
        String expResult = "dashboard";
        String result = instance.editUser();

        assertEquals(expResult, result);
    }
    @Test
    public void testDeleteUser() {
        System.out.println(" Test deleteUser ");
        User instance = new User();
        instance.setId(6);
        String expResult = "dashboard";
        String result = instance.deleteUser();
        assertEquals(expResult, result);
    }
}
