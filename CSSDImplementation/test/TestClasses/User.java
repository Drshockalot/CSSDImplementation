/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;

import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Drshockalotz
 */
public class User {

    public User() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    ///////////////////
    // Test Case 2.1 //
    ///////////////////
    @Test
    public void checkUserAuthentication() throws Throwable {
        PublicTransportationSystem.TravelSystem database = PublicTransportationSystem.TravelSystem.getInstance();
        PublicTransportationSystem.SetOfUsers user_list = database.getUsers();

        // Always retrieve User that has valid details
        PublicTransportationSystem.User test_user = user_list.getUserById(6);

        // Ensure that it is possible to get both a negative result and
        // a positive result from User authentication
        assertFalse(test_user.authenticateUser("pass"));
        assertTrue(test_user.authenticateUser("p"));
    }

    ///////////////////
    // Test Case 2.2 //
    ///////////////////
}
