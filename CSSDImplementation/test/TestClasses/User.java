/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;

import org.junit.AfterClass;
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

    @Test
    public void checkUserAuthentication() throws Throwable {
        PublicTransportationSystem.TravelSystem database = PublicTransportationSystem.TravelSystem.getInstance();
        PublicTransportationSystem.SetOfUsers user_list = database.getUsers();

    }
}
