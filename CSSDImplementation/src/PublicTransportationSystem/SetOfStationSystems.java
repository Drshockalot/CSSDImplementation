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
 *
 * @author DrPoopAlotz // Blame the Tacos
 */
public class SetOfStationSystems extends Vector<StationSystem> implements Serializable {

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
        return super.isEmpty() ? 1 : super.lastElement().getId() + 1;
    }

    public int getNumberOfStationsInZone(Zone zone) {
        int count = 0;
        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getZone().getId() == zone.getId()) {
                count++;
            }
        }

        return count;
    }

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
