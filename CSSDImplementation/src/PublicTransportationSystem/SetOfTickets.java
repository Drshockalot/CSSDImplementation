/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author JoBa
 */
public class SetOfTickets extends Vector<Ticket> {

    float calculateTodaysTotal(float discount, User user, Date date) {
        // Create a PaymentManager to help us with calculating costs
        PaymentManager paymentManager = new PaymentManager();
        float todaysTotal = 0.00f;
        // Iterate through each ticket and add the price on to the total
        SetOfTickets list = getTicketsForUserOnDay(user.getId(), date);
        for (Ticket ticket : list) {
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

    public SetOfTickets getTicketsForUserOnDay(int userId, Date date) {
        SetOfTickets userTickets = getTicketsForUser(userId);
        SetOfTickets retTickets = new SetOfTickets();
        for (int i = 0; i < userTickets.size(); ++i) {
            Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            cal1.setTime(date);
            cal2.setTime(userTickets.get(i).getPurchasedTime());
            boolean sameDay = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                    && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
            if (sameDay) {
                retTickets.add(userTickets.get(i));
            }
        }

        return retTickets;
    }

    public void addTicket(Ticket ticket) {
        this.add(ticket);
    }

    public int nextId() {
        // Return the next available ID
        return super.isEmpty() ? 1 : super.lastElement().getTicketId() + 1;
    }
}
