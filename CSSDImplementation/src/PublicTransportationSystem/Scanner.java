/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.io.Serializable;

/**
 *
 * @author JoBa
 */
public class Scanner implements Serializable {

    public int read(TravelCard travelCard) {
        return travelCard.getId();
    }
}
