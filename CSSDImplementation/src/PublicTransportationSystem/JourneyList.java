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
public class JourneyList extends Vector<Journey> implements Serializable {

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

    public JourneyList deserializeJourneys() throws ClassNotFoundException {
        try {
            FileInputStream fileIn = new FileInputStream("files/journeys.ser");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);

            JourneyList obj = (JourneyList) objIn.readObject();

            fileIn.close();
            objIn.close();
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
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
