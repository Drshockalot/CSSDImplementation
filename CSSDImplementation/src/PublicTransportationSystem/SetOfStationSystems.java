/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.util.Vector;

/**
 *
 * @author Drshockalotz
 */
public class SetOfStationSystems extends Vector<StationSystem> {

    public void addStationSystem(StationSystem station) {
        super.add(station);
    }

    public StationSystem getStationSystemById(int id) {
        //  Locate correct StationSystem Object to return
        //  Search by param (id)
        for (StationSystem sys : this) {
            if (sys.getId() == id) {
                return sys;
            }
        }
        // Return null if no valid StationSystem object was found
        return null;
    }
}
