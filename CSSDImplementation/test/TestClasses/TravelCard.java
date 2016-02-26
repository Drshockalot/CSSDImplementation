/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;

import PublicTransportationSystem.*;
import java.util.Date;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Drshockalotz
 */
public class TravelCard {

    public TravelCard() {
    }

    @BeforeClass
    public static void setUpClass() throws Throwable {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    ///////////////////
    // Test Case 1.1 //
    ///////////////////
    @Test
    public void checkTravelCardExpiryDate() throws Throwable {
        PublicTransportationSystem.TravelCard test_travel_card = TravelSystem.getInstance().getTravelCards().getTravelCardById(1);

        // Get local copies of expiry/creation dates from the selcted TravelCard
        Date card_creation_date = test_travel_card.getCreationDate();
        Date card_expiry_date = test_travel_card.getExpiryDate();

        // Assert that the dates on the TravelCard exist
        assertFalse(card_creation_date == null);
        assertFalse(card_expiry_date == null);

        // Generate duplicate expiry date based off of creation date of selected TravelCard
        // ExpiryDate for TravelCard is equal to three years from time of Creation
        int future_days = 365 * 3;
        Date test_expiry_date = DateManipulationUtil.generateTestExpiryDateFromCreationDate(card_creation_date, future_days);

        // Assert that the ExpiryDate is not equal to CreationDate
        assertFalse(test_expiry_date == card_creation_date);

        // Necessary to compare dates using the below method
        // Successful comparison: return value of 0
        // Unsuccessful comparison: return value of > OR < 0
        int comparison_result = test_expiry_date.compareTo(card_expiry_date);
        assertTrue(comparison_result == 0);
    }

    ///////////////////
    // Test Case 1.2 //
    ///////////////////
    @Test
    public void hasCorrectPass() throws Throwable {
        PublicTransportationSystem.TravelSystem database = PublicTransportationSystem.TravelSystem.getInstance();
        PublicTransportationSystem.SetOfTravelCards card_list = database.getTravelCards();
        PublicTransportationSystem.ZoneList zone_list = database.getZones();
        PublicTransportationSystem.TravelCard test_card = card_list.getTravelCardById(1);

        // Add suitable Pass for testing purposes
        Pass test_pass = new Pass(TypeEnums.PassType.BUSJOURNEY);
        Zone test_departure_zone = zone_list.getZoneById(1);
        Zone test_arrival_zone = zone_list.getZoneById(2);

        // Ensure that the Pass has correct zones allocated
        test_pass.setDepartureZone(test_departure_zone);
        test_pass.setArrivalZone(test_arrival_zone);

        test_card.setPass(test_pass);

        // Ensure that the checkForPass method correctly evaluates the given
        // Pass on the Zone parameters
        boolean result = test_card.checkForPass(test_arrival_zone, test_departure_zone);
        assertTrue(result);
    }
}
