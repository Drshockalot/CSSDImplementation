/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author JoBa
 */
public class SetOfGateways extends Vector<Gateway> implements Serializable {

    public Gateway getGatewayById(int id) {
        //  Locate correct Gateway Object to return
        //  Search by param (id)
        for (Gateway gateway : this) {
            if (gateway.getId() == id) {
                return gateway;
            }
        }
        // Return null if no valid Gateway object was found
        return null;
    }

    public int getNextId() {
        // Get the last element in the vector, get the id and add one in order
        // to get the next available ID
        return super.isEmpty() ? 1 : super.lastElement().getId() + 1;
    }
}
