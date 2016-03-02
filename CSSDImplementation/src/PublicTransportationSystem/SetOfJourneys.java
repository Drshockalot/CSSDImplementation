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
 * @author JoBa
 */
public class SetOfJourneys extends Vector<Journey> implements Serializable {

    private static final long serialVersionUID = 6001781469688361443L;

    public Journey getJourneyAndPriceFromZones(Zone departureZone, Zone arrivalZone) {
        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getStartZone().getName().equals(departureZone.getName())
                    && super.get(i).getEndZone().getName().equals(arrivalZone.getName())) {
                return super.get(i);
            }
        }
        return null;
        /*

        //  Add price for corresponding zones - Is this right??
        float price = 4.20f;
        float onPeak = 4.20f;
        Journey ret = new Journey(price, onPeak, departureZone, arrivalZone);
        return ret;*/
    }

    public Journey getJourney(Zone startZone, Zone endZone) {
        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getStartZone().getId() == startZone.getId()) {
                if (super.get(i).getEndZone().getId() == endZone.getId()) {
                    return super.get(i);
                }
            }
        }

        return null;
    }

    public SetOfJourneys getAllJourneysContainingZone(Zone zone) {
        SetOfJourneys journeys = new SetOfJourneys();
        for (int i = 0; i < super.size(); i++) {
            if ((super.get(i).getStartZone().getId() == zone.getId())
                    || (super.get(i).getEndZone().getId() == zone.getId())) {
                journeys.add(super.get(i));
            }
        }

        return journeys;
    }

    public SetOfZones getAllZonesDepartingFromStartZone(Zone zone) {
        SetOfZones zoneList = new SetOfZones();
        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getStartZone().getId() == zone.getId()) {
                zoneList.add(super.get(i).getEndZone());
            }
        }

        return zoneList;
    }

    public int getTotalJourneysToZone(Zone zone) {
        int count = 0;
        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getEndZone().getId() == zone.getId()) {
                count++;
            }
        }

        return count;
    }

    public int getTotalJourneysFromZone(Zone zone) {
        int count = 0;
        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getStartZone().getId() == zone.getId()) {
                count++;
            }
        }

        return count;
    }

    public SetOfJourneys deserializeJourneys() throws ClassNotFoundException {
        try {
            FileInputStream fileIn = new FileInputStream("files/journeys.ser");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);

            SetOfJourneys obj = (SetOfJourneys) objIn.readObject();

            fileIn.close();
            objIn.close();
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public SetOfZones getDestinationsForDepartureZone(int zoneId) {
        SetOfZones zoneList = new SetOfZones();

        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getStartZone().getId() == zoneId) {
                zoneList.add(super.get(i).getEndZone());
            }
        }

        return zoneList;
    }

    public SetOfZones getDeparturesForDestinationZone(int zoneId) {
        SetOfZones zoneList = new SetOfZones();

        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getEndZone().getId() == zoneId) {
                zoneList.add(super.get(i).getStartZone());
            }
        }

        return zoneList;
    }

    public void serializeJourneys() {
        try {
            FileOutputStream fileOut = new FileOutputStream("files/journeys.ser");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(this);

            objOut.close();
            fileOut.close();
            System.out.println("Serialised journeys");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
