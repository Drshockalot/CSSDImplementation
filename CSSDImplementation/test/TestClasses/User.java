/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;

import PublicTransportationSystem.*;
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
public class User {

    public User() {
    }

    static float manual_todays_total;

    @BeforeClass
    public static void setUpClass() throws Throwable {
        PublicTransportationSystem.TravelSystem travel_system = PublicTransportationSystem.TravelSystem.getInstance();
        PublicTransportationSystem.StationSystem station_system = travel_system.getStationSystems().getStationSystemById(1);
        SetOfGateways gateways = station_system.getStationGateways();
        PublicTransportationSystem.Gateway gateway = gateways.getGatewayById(1);

        PublicTransportationSystem.SetOfTravelCards travel_cards = travel_system.getTravelCards();
        PublicTransportationSystem.TravelCard travel_card = travel_cards.getTravelCardById(1);
        travel_card.addFunds(7.00f);

        SetOfTickets sysList = travel_system.getTickets();

        boolean peak = station_system.isPeak();

        gateway.PerformScanIn(travel_card);
        gateway.PerformScanOut(travel_card);

        gateway.PerformScanIn(travel_card);
        gateway.PerformScanOut(travel_card);

        gateway.PerformScanIn(travel_card);
        gateway.PerformScanOut(travel_card);

        SetOfTickets ticketList = sysList.getTicketsForUserOnDay(travel_card.getUser().getId(), new Date());
        PaymentManager pMgr = new PaymentManager();
        for (Ticket ticket : ticketList) {
            if (ticket.getIsPaid()) {
                manual_todays_total += pMgr.calculatePrice(ticket, travel_card.getDiscount());
            }
        }
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
    @Test
    public void checkUserTicketsOnDay() throws Throwable {
        PublicTransportationSystem.TravelSystem travel_system = PublicTransportationSystem.TravelSystem.getInstance();
        PublicTransportationSystem.SetOfTickets tickets = travel_system.getTickets();
        PublicTransportationSystem.SetOfTravelCards travel_cards = travel_system.getTravelCards();
        PublicTransportationSystem.TravelCard travel_card = travel_cards.getTravelCardById(1);
        PublicTransportationSystem.User user = travel_card.getUser();

        SetOfTickets userTickets = tickets.getTicketsForUserOnDay(user.getId(), new Date());

        userTickets.stream().forEach((ticket) -> {
            assertTrue(DateManipulationUtil.isOnSameDay(ticket.getPurchasedTime(), new Date()));
        });
    }

    ///////////////////
    // Test Case 2.3 //
    ///////////////////
    @Test
    public void checkUserSearchMethods() throws Throwable {
        PublicTransportationSystem.TravelSystem travel_system = PublicTransportationSystem.TravelSystem.getInstance();
        SetOfUsers users = travel_system.getUsers();

        String test_email = "test@test.com";
        String test_username = "JoBa";
        int test_id = 3;

        PublicTransportationSystem.User email_user = users.getUserByEmail(test_email);
        PublicTransportationSystem.User username_user = users.getUserByUsername(test_username);
        PublicTransportationSystem.User id_user = users.getUserById(test_id);

        assertTrue(email_user.getEmail().equals(test_email));
        assertTrue(username_user.getUsername().equals(test_username));
        assertTrue(id_user.getId() == test_id);
    }

    ///////////////////
    // Test Case 2.4 //
    ///////////////////
    @Test
    public void checkCumulativeUserTicketPrice() throws Throwable {
        PublicTransportationSystem.TravelSystem travel_system = PublicTransportationSystem.TravelSystem.getInstance();
        PublicTransportationSystem.SetOfTickets tickets = travel_system.getTickets();
        PublicTransportationSystem.SetOfTravelCards travel_cards = travel_system.getTravelCards();
        PublicTransportationSystem.TravelCard travel_card = travel_cards.getTravelCardById(1);
        PublicTransportationSystem.User user = travel_card.getUser();

        SetOfTickets userTickets = tickets.getTicketsForUserOnDay(user.getId(), new Date());

        float auto_todays_total = userTickets.calculateTodaysTotal(travel_card.getDiscount(), user, new Date());

        assertTrue(manual_todays_total == auto_todays_total);
    }
}
