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

    private static final long serialVersionUID = -8162005939343697380L;

    public int read(TravelCard travelCard) {
        return travelCard.getId();
    }

    public int readTicket(Ticket ticket) {
        // Simulate the reading of a paper ticket
        return ticket.getTicketId();
    }
}
