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
public class TicketList extends Vector<Ticket> {

    float calculateTodaysTotal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int nextId() {
        return super.isEmpty() ? 1 : super.lastElement().getTicketId() + 1;
    }
}
