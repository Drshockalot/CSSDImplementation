/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;

import java.util.Calendar;
import java.util.Date;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Drshockalotz
 */
public class StationSystem {

    public StationSystem() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    ///////////////////
    // Test Case 2.5 //
    ///////////////////
    @Test
    public void checkPeakTimeRequest() throws Throwable {
        PublicTransportationSystem.TravelSystem travel_system = PublicTransportationSystem.TravelSystem.getInstance();
        PublicTransportationSystem.SetOfStationSystems station_systems = travel_system.getStationSystems();
        PublicTransportationSystem.StationSystem station_system = station_systems.getStationSystemById(1);

        boolean result = station_system.isPeak();
        Date t = new Date();
        Calendar peakFloor = Calendar.getInstance();
        Calendar peakCeiling = Calendar.getInstance();
        Calendar now = Calendar.getInstance();

        now.setTime(t);
        peakFloor.setTime(t);
        peakCeiling.setTime(t);
        peakFloor.set(peakFloor.get(Calendar.YEAR), peakFloor.get(Calendar.MONTH), peakFloor.get(Calendar.DAY_OF_MONTH), 16, 0);
        peakCeiling.set(peakCeiling.get(Calendar.YEAR), peakCeiling.get(Calendar.MONTH), peakCeiling.get(Calendar.DAY_OF_MONTH), 19, 0);
        boolean peak = (peakFloor.get(Calendar.HOUR) <= now.get(Calendar.HOUR) && peakFloor.get(Calendar.MINUTE) <= now.get(Calendar.MINUTE)
                && peakCeiling.get(Calendar.HOUR) >= now.get(Calendar.HOUR) && peakCeiling.get(Calendar.MINUTE) >= now.get(Calendar.MINUTE));

        if (peak) {
            assertTrue(result);
        } else {
            assertFalse(result);
        }
    }
}
