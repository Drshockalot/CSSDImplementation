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
@Suite.SuiteClasses({TestSuites.Suite1.class, TestSuites.Suite3.class, TestSuites.Suite2.class, TestSuites.Suite4.class})
public class FullSuiteTest {

    @BeforeClass
    public static void setUpClass() throws Exception, Throwable {
        System.out.println("Running Full Suite Test...");
        TravelSystem.getInstance().resetData();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("Finishing Full Suite Test...");
    }

}
