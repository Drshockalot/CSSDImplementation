/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;

import PublicTransportationSystem.*;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Drshockalotz
 */
public class SetOfTravelCards {

    public SetOfTravelCards() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void checkCorrectTravelCardNextID() throws Throwable {
        int number_of_travel_cards = TravelSystem.getInstance().getTravelCards().size();

        // Create a copy of next id for later comparison
        int travel_card_next_id = TravelSystem.getInstance().getTravelCards().nextId();

        // The next id generated through manual means
        // THIS CALCULATION SHOULD ALWAYS REFLECT THE METHOD USED TO GENERATE AN ID
        int test_id = number_of_travel_cards + 1;

        // Assert that the id generated through both automated and manual means
        // equal the same value
        assertTrue(test_id == travel_card_next_id);
    }

    @Test
    public void checkCorrectTravelCardIDReturn() throws Throwable {
        PublicTransportationSystem.TravelSystem database = PublicTransportationSystem.TravelSystem.getInstance();
        PublicTransportationSystem.SetOfTravelCards card_list = database.getTravelCards();

        // Change this variable to test different TravelCards
        // (Ensure that it is within bounds for this test,
        //  out of bounds testing is a different test)
        int test_id = 1;

        // Create copy of TravelCard obtained through search by ID;
        PublicTransportationSystem.TravelCard test_travel_card_from_id = card_list.getTravelCardById(test_id);

        // Get copy of TravelCard directly through the Set
        // The place of the object in the Set will always be the ID - 1
        PublicTransportationSystem.TravelCard test_travel_card_from_set_directly = card_list.elementAt(test_id - 1);

        // Assert that the two objects returned from the two different methods
        // are in fact the same object
        assertTrue(test_travel_card_from_id == test_travel_card_from_set_directly);
    }

    @Test
    public void checkOutOfBoundsTravelCardIDReturn() throws Throwable {
        PublicTransportationSystem.TravelSystem database = PublicTransportationSystem.TravelSystem.getInstance();
        PublicTransportationSystem.SetOfTravelCards card_list = database.getTravelCards();

        int card_list_size = card_list.size();

        // id used for the purpose of this test
        // Intentionally a high/ludicrous number to test out of bounds
        int test_id = 5000;

        // Ensure that the test_id is a valid number for the purpose of this test
        // Must be above 0
        // Must be above the current size of the set
        assertTrue(test_id > 0 && test_id > card_list_size);

        PublicTransportationSystem.TravelCard test_card = card_list.getTravelCardById(test_id);

        // Ensure that the method returns a null value when attempting to
        // access a TravelCard that is out of bounds of the container
        assertTrue(test_card == null);
    }
}
