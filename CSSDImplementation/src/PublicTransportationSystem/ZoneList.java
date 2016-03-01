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
 * @author jonathondickson
 */
public class ZoneList extends Vector<Zone> implements Serializable {

    private static final long serialVersionUID = 7852571661854962706L;

    public Zone getZoneById(int id) {
        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getId() == id) {
                return super.get(i);
            }
        }

        return null;
    }

    public boolean isZoneNameUnique(String zoneName) {
        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getName().equalsIgnoreCase(zoneName)) {
                return false;
            }
        }

        return true;
    }

    // Overloaded to check when editing zone, the other version
    // would throw an error because it would find itself
    public boolean isZoneNameUnique(String zoneName, int zoneId) {
        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getName().equalsIgnoreCase(zoneName)) {
                if (super.get(i).getId() != zoneId) {
                    return false;
                }
            }
        }

        return true;
    }

    public String[] getZonesAsStringArray() {
        String[] zoneList = new String[super.size()];

        for (int i = 0; i < super.size(); i++) {
            zoneList[i] = super.get(i).getName();
        }

        return zoneList;
    }

    public String[] getZonesAsStringArray(ZoneList zones) {
        String[] zoneList = new String[zones.size()];

        for (int i = 0; i < zones.size(); i++) {
            zoneList[i] = zones.get(i).getName();
        }

        return zoneList;
    }

    public Zone getZoneByName(String zoneName) {
        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getName().equalsIgnoreCase(zoneName)) {
                return super.get(i);
            }
        }

        return null;
    }

    public ZoneList getZonesNotInList(ZoneList zones) {
        ZoneList list = new ZoneList();

        for (int i = 0; i < super.size(); i++) {
            if (zones.getZoneById(super.get(i).getId()) == null) {
                list.add(super.get(i));
            }
        }

        return list;
    }

    public void serializeZones() {
        try {
            FileOutputStream fileOut = new FileOutputStream("files/zones.ser");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(this);

            objOut.close();
            fileOut.close();
            System.out.println("Serialised zones");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ZoneList deserializeZones() throws ClassNotFoundException {
        try {
            FileInputStream fileIn = new FileInputStream("files/zones.ser");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);

            ZoneList obj = (ZoneList) objIn.readObject();

            fileIn.close();
            objIn.close();
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getNextId() {
        return super.isEmpty() ? 1 : super.lastElement().getId() + 1;
    }
}
