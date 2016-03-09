/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

/**
 * Class made to help find the most popular zone
 *
 * @author jonathondickson
 */
public class ZoneFrequency {

    private Zone zone;
    private int travelCount;

    public ZoneFrequency(Zone zone, int travelCount) {
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

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public void setTravelCount(int travelCount) {
        this.travelCount = travelCount;
    }
}
