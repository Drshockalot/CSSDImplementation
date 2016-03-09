/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

/**
 * Container class for StationSystems. Accessible via TravelSystem. Allows
 * access to required StationSystem
 *
 * @author DrShockalotz
 */
public class SetOfStationSystems extends Vector<StationSystem> implements Serializable {

    private static final long serialVersionUID = 98925643773034062L;

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

    public int getNextId() {
        // if set is empty, return 1, else return next id
        return super.isEmpty() ? 1 : super.lastElement().getId() + 1;
    }

    // get number of stations associated with the zone parameter,
    // checks against zone id and incremements count accordingly
    public int getNumberOfStationsInZone(Zone zone) {
        int count = 0;
        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getZone().getId() == zone.getId()) {
                count++;
            }
        }
        return count;
    }

    // get specific station from zone passed through,
    // checks against name of zone
    public StationSystem getStationFromZone(Zone zone) {
        for (StationSystem system : this) {
            if (system.getZone().getName().equals(zone.getName())) {
                return system;
            }
        }

        return null;
    }

    // check for if name is already present within set
    public boolean nameIsUnique(String name) {
        return this.stream().noneMatch((system) -> (system.getName().equals(name)));
    }

    // load in serialized class
    public SetOfStationSystems deserializeStationSystems() throws ClassNotFoundException {
        try {
            FileInputStream fileIn = new FileInputStream("files/stationSystems.ser");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);

            SetOfStationSystems obj = (SetOfStationSystems) objIn.readObject();

            fileIn.close();
            objIn.close();
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // save serialized class
    public void serializeStationSystems() {
        try {
            FileOutputStream fileOut = new FileOutputStream("files/stationSystems.ser");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(this);

            objOut.close();
            fileOut.close();
            System.out.println("Serialised Station Systems");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
