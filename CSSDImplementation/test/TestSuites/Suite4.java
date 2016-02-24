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
@Suite.SuiteClasses({TestSuites.Suite1.class, TestSuites.Suite2.class, TestSuites.Suite3.class})
public class Suite4 {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

}
