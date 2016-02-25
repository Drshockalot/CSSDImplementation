/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestSuites;

import PublicTransportationSystem.TravelSystem;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Drshockalotz
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TestClasses.TravelCard.class, TestClasses.SetOfTravelCards.class})
public class Suite1 {

    @BeforeClass
    public static void setUpClass() throws Exception, Throwable {
        System.out.println("Running Test Suite 1...");
        TravelSystem.getInstance().resetData();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("Finishing Test Suite 1...");
    }
}
