/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author JoBa
 */
public class StationSystem implements Serializable {

    private static final long serialVersionUID = 8478671689357505568L;

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

    public boolean isPeak() {
        Date t = new Date();
        Calendar peakFloor = Calendar.getInstance();
        Calendar peakCeiling = Calendar.getInstance();
        Calendar now = Calendar.getInstance();

        now.setTime(t);
        peakFloor.setTime(t);
        peakCeiling.setTime(t);
        peakFloor.set(peakFloor.get(Calendar.YEAR), peakFloor.get(Calendar.MONTH), peakFloor.get(Calendar.DAY_OF_MONTH), 16, 0);
        peakCeiling.set(peakCeiling.get(Calendar.YEAR), peakCeiling.get(Calendar.MONTH), peakCeiling.get(Calendar.DAY_OF_MONTH), 19, 0);
        return (peakFloor.get(Calendar.HOUR) <= now.get(Calendar.HOUR) && peakFloor.get(Calendar.MINUTE) <= now.get(Calendar.MINUTE)
                && peakCeiling.get(Calendar.HOUR) >= now.get(Calendar.HOUR) && peakCeiling.get(Calendar.MINUTE) >= now.get(Calendar.MINUTE));
    }
}
