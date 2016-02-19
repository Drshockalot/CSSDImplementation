/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.util.Vector;

/**
 *
 * @author JoBa
 */
public class JourneyList extends Vector<Journey> {

    public JourneyList() {

    }

    public Journey getJourneyAndPriceFromZones(Zone departureZone, Zone arrivalZone) {
        //  Add price for corresponding zones - Is this right??
        float price = 4.20f;
        Journey ret = new Journey(price);
        return ret;
    }

//    public Journey getJourney(Zone startZone, Zone endZone) {
//
//    }
}
