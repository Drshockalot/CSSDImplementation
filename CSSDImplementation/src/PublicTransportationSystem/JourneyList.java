/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

/**
 *
 * @author JoBa
 */
public class JourneyList {

    public JourneyList() {

    }

    public Journey getJourneyAndPriceFromZones(Zone departureZone, Zone arrivalZone) {
        //  Add price for corresponding zones
        float price = 4.20f;
        Journey ret = new Journey(price);
        return ret;
    }
}
