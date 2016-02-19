/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.util.Vector;

/**
 *
 * @author jonathondickson
 */
public class ZoneList extends Vector<Zone> {

    public Zone getZoneById(int id) {
        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getId() == id) {
                return super.get(i);
            }
        }

        return null;
    }
}
