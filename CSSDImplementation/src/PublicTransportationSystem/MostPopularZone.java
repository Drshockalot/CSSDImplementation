/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

/**
 *
 * @author jonathondickson
 */
public class MostPopularZone {

    private Zone zone;
    private int travelCount;

    public MostPopularZone(Zone zone, int travelCount) {
        this.zone = zone;
        this.travelCount = travelCount;
    }

    public Zone getZone() {
        return this.zone;
    }

    public int getTravelCount() {
        return travelCount;
    }

    public void incrementTravelCount() {
        this.travelCount++;
    }
}
