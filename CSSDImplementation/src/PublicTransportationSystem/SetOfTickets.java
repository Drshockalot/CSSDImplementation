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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    private float calculateDiscountToSubtract(int userId, float price) {
        try {
            // Gets the user based of user id passed in
            User user = TravelSystem.getInstance().getUsers().getUserById(userId);
            // Gets the users travel card
            TravelCard tc = TravelSystem.getInstance().getTravelCards().getTravelCardById(user.getTravelCardId());
            // Ensures there is a travel card
            if (tc != null) {
                // Calculates the amount of discount to subtract off price passed in
                return (price / 100) * tc.getDiscount();
            }
        } catch (Throwable ex) {
            Logger.getLogger(SetOfTickets.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0.00f;
    }

    public float calculateTodaysRevenue() {
        float revenue = 0.00f;

        // Loops through all of the tickets
        for (int i = 0; i < super.size(); i++) {
            // Checks whether the purchase date of a ticket was today
            if (getDateFormatted(super.get(i).getPurchasedTime()).trim().equals(getDateFormatted(new Date()))) {
                // Checks whether the ticket is on peak
                if (super.get(i).isPeakTicket()) {
                    // Checks whether the ticket has a user id, means they have
                    // a travel card
                    if (super.get(i).getUserId() != 0) {
                        // Adds the on peak price of the ticket minus any
                        // discount to the revenue
                        revenue += super.get(i).getJourney().getOnPeakPrice() - calculateDiscountToSubtract(
                                super.get(i).getUserId(), super.get(i).getJourney().getOnPeakPrice());
                    } else {
                        // Adds the on peak price of the ticket to the revenue
                        revenue += super.get(i).getJourney().getOnPeakPrice();
                    }
                } else if (super.get(i).getUserId() != 0) {
                    // Journey is not on peak so get the off peak price minus the discount
                    // and add it to the revenue
                    revenue += super.get(i).getJourney().getOffPeakPrice() - calculateDiscountToSubtract(
                            super.get(i).getUserId(), super.get(i).getJourney().getOffPeakPrice());
                } else {
                    // Gets the off peak price of the ticket and adds it to the revenue
                    revenue += super.get(i).getJourney().getOffPeakPrice();
                }
            }
        }

        return revenue;
    }

    public Zone getMostPopularZone() {
        ArrayList<ZoneFrequency> popularZones = new ArrayList();
        try {
            // Gets all of the zones
            SetOfZones zones = TravelSystem.getInstance().getZones();

            // Loops through the zones
            for (Zone zone : zones) {
                // Instantiates new zone frequency
                ZoneFrequency popularZone = new ZoneFrequency(zone, 0);
                // Adds the zone frequency to the array list
                popularZones.add(popularZone);
            }

            // Loops through all of the tickets
            for (int i = 0; i < super.size(); i++) {
                // Ensures the ticket was purchased today
                if (getDateFormatted(super.get(i).getPurchasedTime()).trim().equals(getDateFormatted(new Date()))) {
                    // Loops through the popular zones
                    for (ZoneFrequency popularZone : popularZones) {
                        // Checks if the start zone of current ticket equals start zone of this popular zone
                        if (super.get(i).getJourney().getStartZone().getId() == popularZone.getZone().getId()) {
                            // Increments the count on the popular zone
                            popularZone.incrementTravelCount();
                        }
                        // Checks if the end zone of current ticket equals end zone of this popular zone
                        if (super.get(i).getJourney().getEndZone().getId() == popularZone.getZone().getId()) {
                            // Increments the count on the popular zone
                            popularZone.incrementTravelCount();
                        }
                    }
                }
            }

        } catch (Throwable ex) {
            Logger.getLogger(SetOfTickets.class.getName()).log(Level.SEVERE, null, ex);
        }

        ZoneFrequency zoneToReturn = new ZoneFrequency(null, 0);
        // Loops through the popular zones populated in last loop
        for (ZoneFrequency popZone : popularZones) {
            // Check the zone to return has value
            if (zoneToReturn.getZone() != null) {
                // If the current zone has a larger count than the one currently
                // held in zone to return
                if (popZone.getTravelCount() > zoneToReturn.getTravelCount()) {
                    // Replace the current zone to return with the new most
                    // popular zone
                    zoneToReturn.setZone(popZone.getZone());
                    zoneToReturn.setTravelCount(popZone.getTravelCount());
                }
            } else {
                // Zone to return does not have value so set to current zone
                zoneToReturn.setZone(popZone.getZone());
                zoneToReturn.setTravelCount(popZone.getTravelCount());
            }

        }

        return zoneToReturn.getZone();
    }

    public Ticket getTicketById(int ticketId) {
        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getTicketId() == ticketId) {
                // Ticket with matching Id found, return it
                return super.get(i);
            }
        }
        // No ticket found, return null
        return null;
    }

    // Gets the tickets for the user id passed
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
        // Get all tickets for user
        SetOfTickets userTickets = getTicketsForUser(userId);
        SetOfTickets retTickets = new SetOfTickets();
        for (int i = 0; i < userTickets.size(); ++i) {
            Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            cal1.setTime(date);
            cal2.setTime(userTickets.get(i).getPurchasedTime());
            // Ensure the ticket is on the same day
            boolean sameDay = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                    && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
            if (sameDay) {
                // Add the ticket to the tickets to return
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

    public int getOffPeakTicketsForToday() {
        int count = 0;

        for (int i = 0; i < super.size(); i++) {
            // Ensure ticket is off peak
            if (!super.get(i).isPeakTicket()) {
                // Ensure tickets are for today
                if (getDateFormatted(super.get(i).getPurchasedTime()).trim().equals(getDateFormatted(new Date()))) {
                    count++;
                }
            }
        }

        return count;
    }

    public int getOnPeakTicketsForToday() {
        int count = 0;

        for (int i = 0; i < super.size(); i++) {
            // Ensure ticket is on peak
            if (super.get(i).isPeakTicket()) {
                // Ensure ticket is for today
                if (getDateFormatted(super.get(i).getPurchasedTime()).trim().equals(getDateFormatted(new Date()))) {
                    count++;
                }
            }
        }

        return count;
    }

    public int getOffPeakTicketsForJourney(Journey journey) {
        int count = 0;

        for (int i = 0; i < super.size(); i++) {
            // Ensure ticket is off peak
            if (!super.get(i).isPeakTicket()) {
                // Ensure the journey is the same journey as the one passed in
                if (super.get(i).getJourney().getStartZone().getId() == journey.getStartZone().getId()) {
                    if (super.get(i).getJourney().getEndZone().getId() == journey.getEndZone().getId()) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public int getOnPeakTicketsForJourney(Journey journey) {
        int count = 0;

        for (int i = 0; i < super.size(); i++) {
            // Ensure ticket is on peak
            if (super.get(i).isPeakTicket()) {
                // Ensure the journey is the same as the one passed in
                if (super.get(i).getJourney().getStartZone().getId() == journey.getStartZone().getId()) {
                    if (super.get(i).getJourney().getEndZone().getId() == journey.getEndZone().getId()) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public SetOfJourneys getSearchedJourneys(Journey journey, Date startDateTime, Date endDateTime) {
        SetOfJourneys journeys = new SetOfJourneys();

        // Loop through all tickets
        for (int i = 0; i < super.size(); i++) {
            // Ensure journey is the same as the one passed in
            if (super.get(i).getJourney().getStartZone().getId() == journey.getStartZone().getId()) {
                if (super.get(i).getJourney().getEndZone().getId() == journey.getEndZone().getId()) {
                    // Ensure journey ticket was purchased between dates passed in
                    if (super.get(i).getPurchasedTime().after(startDateTime) || super.get(i).getPurchasedTime().equals(startDateTime)) {
                        if (super.get(i).getPurchasedTime().before(endDateTime) || super.get(i).getPurchasedTime().equals(endDateTime)) {
                            // Ensure there are journeys
                            if (journeys.size() > 0) {
                                // Loop through existing journeys stored
                                for (Journey existingJourney : journeys) {
                                    // If journey does not already exist in our list to return then add it
                                    if (existingJourney.getStartZone().getId() != super.get(i).getJourney().getStartZone().getId()) {
                                        if (existingJourney.getEndZone().getId() != super.get(i).getJourney().getEndZone().getId()) {
                                            journeys.add(super.get(i).getJourney());
                                        }
                                    }
                                }
                            } else {
                                // There are no journeys so add it
                                journeys.add(super.get(i).getJourney());
                            }
                        }
                    }
                }
            }
        }

        return journeys;
    }

    // Returns the amount of paper tickets issues today
    public int getNumberOfPaperTicketsForToday() {
        int paperTicketCount = 0;

        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getUserId() == 0) {
                if (getDateFormatted(super.get(i).getPurchasedTime()).trim().equals(getDateFormatted(new Date()))) {
                    paperTicketCount++;
                }
            }
        }

        return paperTicketCount;
    }

    // Returns the number of travel card tickets purchased today
    public int getNumberOfTravelCardTicketsForToday() {
        int count = 0;

        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getUserId() != 0) {
                if (getDateFormatted(super.get(i).getPurchasedTime()).trim().equals(getDateFormatted(new Date()))) {
                    count++;
                }
            }
        }

        return count;
    }

    // Return a formatted date
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
