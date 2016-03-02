/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.io.Serializable;

/**
 *
 * @author JoBa
 */
public class StationSystem implements Serializable {

    private int stationID;
    private String name;
    private String stationType;
    private String location;
    private GPSCoordinates gps;
    private Zone zone;
    private SetOfGateways gateways;
    private boolean peak;

    // Abbreviated Station System to Ss for the following constructor
    public StationSystem(Integer newSsId, String newSsName, String newSsType, String newSsLocation, GPSCoordinates newSsGPSCoords, Zone newSsZone, SetOfGateways gateways, boolean newSsPeak) {
        stationID = newSsId;
        name = newSsName;
        stationType = newSsType;
        location = newSsLocation;
        gps = newSsGPSCoords;
        zone = newSsZone;
        this.gateways = gateways;
        peak = newSsPeak;
    }

    public int getId() {
        return this.stationID;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.stationType;
    }

    public String getLocation() {
        return this.location;
    }

    public GPSCoordinates getGPSPos() {
        return this.gps;
    }

    public SetOfGateways getStationGateways() {
        return this.gateways;
    }

    public Zone getZone() {
        return this.zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public boolean getPeak() {
        return this.peak;
    }
}
