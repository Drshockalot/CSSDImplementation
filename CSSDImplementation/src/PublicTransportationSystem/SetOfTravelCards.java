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
 * @author SackFat
 */
public class SetOfTravelCards extends Vector<TravelCard> implements Serializable {

    public void addTravelCard(TravelCard card) {
        //  Add valid TravelCard to system
        super.add(card);
    }

    public TravelCard getTravelCardById(int id) {
        //  Locate correct TravelCard Object to return
        //  Search by param (id)
        for (TravelCard next : this) {
            if (next.getId() == id) {
                return next;
            }
        }
        //  Return null if no valid TravelCard Object was found
        return null;
    }

    // get travel card by id, search through set of and check for a match on the
    // id. Return if found, else return null
    public TravelCard getUserTravelCard(int travelCardId) {
        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getId() == travelCardId) {
                return super.get(i);
            }
        }

        return null;
    }

    public int getNextId() {
        // if set is empty, return 1, else return next id
        return super.isEmpty() ? 1 : super.lastElement().getId() + 1;
    }

    public SetOfTravelCards deserializeTravelCards() throws ClassNotFoundException {
        try {
            FileInputStream fileIn = new FileInputStream("files/travelCards.ser");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);

            SetOfTravelCards obj = (SetOfTravelCards) objIn.readObject();

            fileIn.close();
            objIn.close();
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void serializeTravelCards() {
        try {
            FileOutputStream fileOut = new FileOutputStream("files/travelCards.ser");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(this);

            objOut.close();
            fileOut.close();
            System.out.println("Serialised Travel Cards");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
