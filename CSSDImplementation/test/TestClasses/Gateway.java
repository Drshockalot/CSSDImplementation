/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;

import PublicTransportationSystem.Pass;
import PublicTransportationSystem.SetOfGateways;
import PublicTransportationSystem.TypeEnums;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Drshockalotz
 */
public class Gateway {

    public Gateway() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    ///////////////////
    // Test Case 3.1 //
    ///////////////////
    @Test
    public void checkPerformScanInApprove() throws Throwable {
        PublicTransportationSystem.TravelSystem travel_system = PublicTransportationSystem.TravelSystem.getInstance();
        PublicTransportationSystem.StationSystem station_system = travel_system.getStationSystems().getStationSystemById(1);
        SetOfGateways gateways = station_system.getStationGateways();
        PublicTransportationSystem.Gateway gateway = gateways.getGatewayById(1);

        // Find suitable Travel Card Object
        PublicTransportationSystem.SetOfTravelCards travel_cards = travel_system.getTravelCards();
        PublicTransportationSystem.TravelCard travel_card = travel_cards.getTravelCardById(1);

        // Attempt to scan into Gateway Object using Travel Card
        boolean result = gateway.PerformScanIn(travel_card);

        // Ensure that the Travel Card scanned in successfully
        assertTrue(result);
    }

    ///////////////////
    // Test Case 3.2 //
    ///////////////////
    @Test
    public void checkPerformScanInReject() throws Throwable {
        PublicTransportationSystem.TravelSystem travel_system = PublicTransportationSystem.TravelSystem.getInstance();
        PublicTransportationSystem.StationSystem station_system = travel_system.getStationSystems().getStationSystemById(1);
        SetOfGateways gateways = station_system.getStationGateways();

        PublicTransportationSystem.Gateway gateway = station_system.getStationGateways().getGatewayById(1);

        // Set up an appropriate Travel Card Object
        PublicTransportationSystem.SetOfTravelCards travel_cards = travel_system.getTravelCards();
        PublicTransportationSystem.TravelCard travel_card = travel_cards.getTravelCardById(1);
        travel_card.addFunds(-2.00f);

        // Attempt to scan in using Travel Card that has
        // insufficient funds
        boolean result = gateway.PerformScanIn(travel_card);

        // Ensure that this returns false
        assertFalse(result);
    }

    ///////////////////
    // Test Case 3.3 //
    ///////////////////
    @Test
    public void checkPerformScanOutApprove() throws Throwable {
        PublicTransportationSystem.TravelSystem travel_system = PublicTransportationSystem.TravelSystem.getInstance();
        PublicTransportationSystem.StationSystem station_system = travel_system.getStationSystems().getStationSystemById(1);
        SetOfGateways gateways = station_system.getStationGateways();
        PublicTransportationSystem.Gateway gateway = gateways.getGatewayById(1);

        // Set up an appropriate Travel Card Object
        PublicTransportationSystem.SetOfTravelCards travel_cards = travel_system.getTravelCards();
        PublicTransportationSystem.TravelCard travel_card = travel_cards.getTravelCardById(1);
        travel_card.addFunds(2.00f);

        // Attempt to scan out using a Travel Card that should
        // have sufficient funds
        boolean result = gateway.PerformScanOut(travel_card);

        // Ensure the result is true
        assertTrue(result);
    }

    ///////////////////
    // Test Case 3.4 //
    ///////////////////
    @Test
    public void checkPerformScanOutReject() throws Throwable {
        PublicTransportationSystem.TravelSystem travel_system = PublicTransportationSystem.TravelSystem.getInstance();
        PublicTransportationSystem.StationSystem station_system = travel_system.getStationSystems().getStationSystemById(1);
        SetOfGateways gateways = station_system.getStationGateways();
        PublicTransportationSystem.Gateway gateway = gateways.getGatewayById(1);

        // Set up an appropriate Travel Card object,
        // ensuring that they do not have enough funds,
        // and that they do not have a pass
        PublicTransportationSystem.SetOfTravelCards travel_cards = travel_system.getTravelCards();
        PublicTransportationSystem.TravelCard travel_card = travel_cards.getTravelCardById(2);
        travel_card.setPass(null);
        travel_card.addFunds(-8.50f);

        // Ensure that they are scanned in
        gateway.PerformScanIn(travel_card);

        // Attempt to scan out
        boolean result = gateway.PerformScanOut(travel_card);

        // Even with insufficient funds
        // they should be able to scan out
        assertTrue(result);

        float current_balance = travel_card.getBalance();

        // However, their current balance should fall below 0
        System.out.println(current_balance);
        assertTrue(current_balance < 0);

    }

    ///////////////////
    // Test Case 3.5 //
    ///////////////////
    @Test
    public void checkPerformScanOutWithPass() throws Throwable {
        PublicTransportationSystem.TravelSystem travel_system = PublicTransportationSystem.TravelSystem.getInstance();
        PublicTransportationSystem.StationSystem station_system = travel_system.getStationSystems().getStationSystemById(1);
        SetOfGateways gateways = station_system.getStationGateways();
        PublicTransportationSystem.Gateway gateway = gateways.getGatewayById(1);

        PublicTransportationSystem.SetOfTravelCards travel_cards = travel_system.getTravelCards();
        PublicTransportationSystem.TravelCard travel_card = travel_cards.getTravelCardById(2);

        // Ensure Travel Card Object has a valid pass
        travel_card.setPass(new Pass(TypeEnums.PassType.TRAINDAY));
        travel_card.addFunds(10.00f);
        float balance_before_journey = travel_card.getBalance();

        // Perform Journey with Travel Card
        gateway.PerformScanIn(travel_card);

        boolean result = gateway.PerformScanOut(travel_card);

        float balance_after_journey = travel_card.getBalance();

        // Ensure that it was a successful Journey and
        // that they have not been charged
        assertTrue(result);
        assertTrue(balance_before_journey == balance_after_journey);
    }
}
