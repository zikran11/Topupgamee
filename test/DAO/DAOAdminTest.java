package DAO;

import POJO.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import POJO.UcTopUpUtil;

/**
 * Test class for DAOAdmin with positive and negative test cases.
 */
public class DAOAdminTest {

    public DAOAdminTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Start Testing");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("End Testing");
    }

    @Before
    public void setUp() {
        // Prepare any resources needed before each test
    }

    @After
    public void tearDown() {
        System.out.println("\n");
    }

    @Test
    public void testDeleteUser() {
        System.out.println("Test Delete User");

        DAOAdmin instance = new DAOAdmin();
        Session session = UcTopUpUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // Create a test user for deletion
        User testUser = new User();
        testUser.setUsername("budi");
        testUser.setPassword("budi233");
        session.save(testUser);
        transaction.commit();

        Integer userId = testUser.getId(); // Get the generated ID of the user

        // Start a new transaction to delete the user
        transaction = session.beginTransaction();
        instance.deleteUser(userId);
        transaction.commit();

        // Verifikasi bahwa pengguna telah dihapus
        User deletedUser = (User) session.get(User.class, userId);
        assertNotNull(deletedUser);

        System.out.println("User successfully deleted.");

        session.close();
    }

    @Test
    public void testDeleteUser_NegativeCase() {
        System.out.println("Negative Test Delete User");

        DAOAdmin instance = new DAOAdmin();
        Session session = UcTopUpUtil.getSessionFactory().openSession();

        // Try to delete a user with an ID that does not exist
        Integer invalidUserId = -1; // Assuming this ID does not exist
        Transaction transaction = session.beginTransaction();
        instance.deleteUser(invalidUserId); 
        transaction.commit();

        // Verify that no exception was thrown and the operation is handled gracefully
        User nonExistentUser = (User) session.get(User.class, invalidUserId);
        assertNull("Non-existent user should not be found", nonExistentUser);

        session.close();
    }

    @Test
    public void testEditUser() {
        System.out.println("Test Update User");

        DAOAdmin instance = new DAOAdmin();
        Session session = UcTopUpUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // Create a user for testing update
        User user = new User();
        user.setUsername("TestUser");
        user.setPassword("password123");
        session.save(user);
        transaction.commit();

        Integer userId = user.getId();

        // Start a new transaction to update user
        transaction = session.beginTransaction();
        user.setUsername("UpdatedUser");
        user.setPassword("newpassword");
        instance.editUser(user);
        transaction.commit();

        // Verify the user was updated
        User updatedUser = (User) session.get(User.class, userId);
        assertEquals("UpdatedUser", updatedUser.getUsername());
        assertEquals("newpassword", updatedUser.getPassword());

        session.close();
    }

    @Test
    public void testEditUser_NegativeCase() {
        System.out.println("Negative Test Update User");

        DAOAdmin instance = new DAOAdmin();
        Session session = UcTopUpUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // Create a user object with an invalid ID
        User invalidUser = new User();
        invalidUser.setId(-1); // Assuming this ID does not exist
        invalidUser.setUsername("InvalidUser");
        invalidUser.setPassword("nochange");

        // Try updating a non-existent user
        instance.editUser(invalidUser);
        transaction.commit(); // Commit the transaction

        // Try to retrieve the user with the invalid ID
        User retrievedUser = (User) session.get(User.class, invalidUser.getId());

        // Assert that the retrieved user is null, indicating the update did not occur
        assertNull("User should not be found for the invalid ID", retrievedUser);

        // Close the session after the test
        session.close();
    }

    @Test
    public void testGetById() {
        System.out.println("Test Get User by ID");

        DAOAdmin instance = new DAOAdmin();
        Session session = UcTopUpUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // Create a test user to retrieve
        User testUser = new User();
        testUser.setUsername("RetrieveTestUser");
        testUser.setPassword("passwordRetrieve");
        session.save(testUser);
        transaction.commit();

        Integer userId = testUser.getId();

        // Retrieve user by ID
        List<User> retrievedUser = instance.getbyID(Integer.toString(testUser.getId()));
        assertNotNull(retrievedUser);
        assertTrue(retrievedUser.size() > 0);

        session.close();
    }

    @Test
    public void testGetById_NegativeCase() {
        System.out.println("Negative Test Get User by ID");
        User u = new User();
        u.setId(1000);
        
        DAOAdmin instance = new DAOAdmin();

        List<User> retrievedUser = instance.getbyID(Integer.toString(u.getId()));

        // Assert that no user is found
        assertTrue(retrievedUser.isEmpty());
        assertTrue(retrievedUser.size() == 0);
    }
}
