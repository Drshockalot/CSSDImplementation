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
public class StationSystem {

    private int stationID;
    private String name;
    private TypeEnums.StationType stationType;
    private String location;
    private GPSCoordinates gps;
    private Zone zone;
    private SetOfGateways gateways;

    // Abbreviated Station System to Ss for the following constructor
    public StationSystem(Integer newSsId, String newSsName, TypeEnums.StationType newSsType, String newSsLocation, GPSCoordinates newSsGPSCoords, Zone newSsZone, SetOfGateways gateways) {
        stationID = newSsId;
        name = newSsName;
        stationType = newSsType;
        location = newSsLocation;
        gps = newSsGPSCoords;
        zone = newSsZone;
        this.gateways = gateways;
    }

    public int getId() {
        return this.stationID;
    }

    public String getName() {
        return this.name;
    }

    public TypeEnums.StationType getType() {
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
}
