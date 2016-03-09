/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

/**
 * Contains functions for calculating journey prices, and refunding
 *
 * @author Drshockalotz
 */
public class PaymentManager {

// Methods Begin
// <editor-fold>
    public float calculatePrice(Ticket currentTicket, float discount) {
        // Calculate price taking into account discounts and peak time variables
        if (currentTicket.isPeakTicket()) {
            // On peak calculation
            float ticketPrice = currentTicket.getJourney().getOnPeakPrice();
            return ticketPrice -= ticketPrice * (discount / 100);
        } else {
            // Off peak calculation
            float ticketPrice = currentTicket.getJourney().getOffPeakPrice();
            return ticketPrice -= ticketPrice * (discount / 100);
        }
    }

    // Overloaded method for journeys
    public float calculatePrice(Journey journey, float discount, boolean peak) {
        if (peak) {
            // On peak calculation
            float journeyPrice = journey.getOnPeakPrice();
            return journeyPrice -= journeyPrice * (discount / 100);
        } else {
            // Off peak calculation
            float journeyPrice = journey.getOffPeakPrice();
            return journeyPrice -= journeyPrice * (discount / 100);
        }
    }

    public float calculateRefund(float dailyCap, float todaysTotal) {
        // Calculate refund a user is entitled to when they go over the daily cap
        return todaysTotal - dailyCap;
    }

// </editor-fold>
// Methods End
}
