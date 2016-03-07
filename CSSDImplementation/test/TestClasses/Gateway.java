/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;

import PublicTransportationSystem.*;
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

        PublicTransportationSystem.SetOfTravelCards travel_cards = travel_system.getTravelCards();
        PublicTransportationSystem.TravelCard travel_card = travel_cards.getTravelCardById(1);

        boolean result = gateway.PerformScanIn(travel_card);

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

        PublicTransportationSystem.SetOfTravelCards travel_cards = travel_system.getTravelCards();
        PublicTransportationSystem.TravelCard travel_card = travel_cards.getTravelCardById(1);
        travel_card.addFunds(-2.00f);

        boolean result = gateway.PerformScanIn(travel_card);

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

        PublicTransportationSystem.SetOfTravelCards travel_cards = travel_system.getTravelCards();
        PublicTransportationSystem.TravelCard travel_card = travel_cards.getTravelCardById(1);
        travel_card.addFunds(2.00f);

        boolean result = gateway.PerformScanOut(travel_card);

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

        PublicTransportationSystem.SetOfTravelCards travel_cards = travel_system.getTravelCards();
        PublicTransportationSystem.TravelCard travel_card = travel_cards.getTravelCardById(2);
        travel_card.setPass(null);
        travel_card.addFunds(0.50f);

        gateway.PerformScanIn(travel_card);

        boolean result = gateway.PerformScanOut(travel_card);

        assertTrue(result);

        float current_balance = travel_card.getBalance();

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

        travel_card.setPass(new Pass(TypeEnums.PassType.TRAINDAY));

        float balance_before_journey = travel_card.getBalance();

        gateway.PerformScanIn(travel_card);

        boolean result = gateway.PerformScanOut(travel_card);

        float balance_after_journey = travel_card.getBalance();

        assertTrue(result);
        assertTrue(balance_before_journey == balance_after_journey);
    }
}
