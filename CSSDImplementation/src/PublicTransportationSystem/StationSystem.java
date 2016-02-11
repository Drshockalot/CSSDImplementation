/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;
import java.util.ArrayList;
/**
 *
 * @author JoBa
 */
public class StationSystem {
    private int stationID;
    private String name;
    private String stationType;
    private String location;
    private GPSCoordinates gps;
    private Zone zone;
    private ArrayList<Gateway> scanners;
}
