/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.io.Serializable;

/**
 * Contains methods to read travel cards and Tickets
 *
 * @author JoBa
 */
public class Scanner implements Serializable {

    private static final long serialVersionUID = -8162005939343697380L;

    public int read(TravelCard travelCard) {
        // Simulate the reading of a physical travel card
        return travelCard.getId();
    }

    public int readTicket(Ticket ticket) {
        // Simulate the reading of a paper ticket
        return ticket.getTicketId();
    }
}
