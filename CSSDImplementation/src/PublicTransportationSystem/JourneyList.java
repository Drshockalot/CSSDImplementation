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
        float onPeak = 4.20f;
        Journey ret = new Journey(price, onPeak, departureZone, arrivalZone);
        return ret;
    }

    public Journey getJourney(Zone startZone, Zone endZone) {
        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getStartZone().getId() == startZone.getId()) {
                if (super.get(i).getEndZone().getId() == endZone.getId()) {
                    return super.get(i);
                }
            }
        }

        return null;
    }
}
