/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.util.Vector;

/**
 *
 * @author JoBa
 */
public class SetOfTravelCards extends Vector<TravelCard> {

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

    public int nextId() {
        return super.isEmpty() ? 1 : super.lastElement().getId() + 1;
    }
}
