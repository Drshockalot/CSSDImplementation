/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestSuites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Drshockalotz
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TestClasses.User.class, TestClasses.StationSystem.class})
public class Suite2 {

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Running Test Suite 2...");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("Finishing Test Suite 2...");
    }

}
