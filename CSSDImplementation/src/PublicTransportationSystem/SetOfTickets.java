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
public class SetOfTickets extends Vector<Ticket> {

    float calculateTodaysTotal(float discount) {
        // Create a PaymentManager to help us with calculating costs
        PaymentManager paymentManager = new PaymentManager();
        float todaysTotal = 0.00f;
        // Iterate through each ticket and add the price on to the total
        for (Ticket ticket : this) {
            // Only if it has been paid for
            if (ticket.getIsPaid()) {
                todaysTotal += paymentManager.calculatePrice(ticket, discount);
            }
        }

        return todaysTotal;
    }

    public Ticket createNewTicket(Journey journey, TypeEnums.TicketType type, boolean peak, int userId) {
        // Create a new ticket based upon journey
        return new Ticket(this.nextId(), type, journey, peak, userId);
    }

    public SetOfTickets getTicketsForUser(int userId) {
        SetOfTickets userTickets = new SetOfTickets();
        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getUserId() == userId) {
                userTickets.add(super.get(i));
            }
        }

        return userTickets;
    }

    public void addTicket(Ticket ticket) {
        this.add(ticket);
    }

    public int nextId() {
        // Return the next available ID
        return super.isEmpty() ? 1 : super.lastElement().getTicketId() + 1;
    }
}
