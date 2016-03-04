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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author JoBa
 */
public class SetOfTickets extends Vector<Ticket> implements Serializable {

    private static final long serialVersionUID = 8865672849740829174L;

    public float calculateTodaysTotal(float discount, User user, Date date) {
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

    public SetOfTickets getUnusedTicketsForUser(int userId) {
        // Return a users 'unused' tickets
        SetOfTickets userTickets = getTicketsForUser(userId);
        SetOfTickets unusedTickets = new SetOfTickets();
        for (Ticket userTicket : userTickets) {
            if (!userTicket.getIsUsed()) {
                unusedTickets.add(userTicket);
            }
        }
        return unusedTickets;
    }

    public int getOffPeakTicketsForJourney(Journey journey) {
        int count = 0;

        for (int i = 0; i < super.size(); i++) {
            if (getDateFormatted(super.get(i).getPurchasedTime()).trim().equals(getDateFormatted(new Date()))) {
                if (!super.get(i).isPeakTicket()) {
                    if (super.get(i).getJourney().getStartZone().getId() == journey.getStartZone().getId()) {
                        if (super.get(i).getJourney().getEndZone().getId() == journey.getEndZone().getId()) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

    public int getOnPeakTicketsForJourney(Journey journey) {
        int count = 0;

        for (int i = 0; i < super.size(); i++) {
            if (getDateFormatted(super.get(i).getPurchasedTime()).trim().equals(getDateFormatted(new Date()))) {
                if (super.get(i).isPeakTicket()) {
                    if (super.get(i).getJourney().getStartZone().getId() == journey.getStartZone().getId()) {
                        if (super.get(i).getJourney().getEndZone().getId() == journey.getEndZone().getId()) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

    private String getDateFormatted(Date date) {
        return new SimpleDateFormat("dd-MM-yyyy").format(date);
    }

    public void addTicket(Ticket ticket) {
        this.add(ticket);
    }

    public int getNextId() {
        // Return the next available ID
        return super.isEmpty() ? 1 : super.lastElement().getTicketId() + 1;
    }

    public SetOfTickets deserializeTickets() throws ClassNotFoundException {
        try {
            FileInputStream fileIn = new FileInputStream("files/tickets.ser");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);

            SetOfTickets obj = (SetOfTickets) objIn.readObject();

            fileIn.close();
            objIn.close();
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void serializeTickets() {
        try {
            FileOutputStream fileOut = new FileOutputStream("files/tickets.ser");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(this);

            objOut.close();
            fileOut.close();
            System.out.println("Serialised tickets");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
