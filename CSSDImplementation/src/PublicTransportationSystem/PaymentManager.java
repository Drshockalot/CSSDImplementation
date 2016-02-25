/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

/**
 *
 * @author Drshockalotz
 */
public class PaymentManager {

// Methods Begin
// <editor-fold>
    public float calculatePrice(Ticket currentTicket, float discount) {
        // Calculate price taking into account discounts and peak time variables
        if (currentTicket.isPeakTicket()) {
            float ticketPrice = currentTicket.getJourney().getOnPeakPrice();
            return ticketPrice -= ticketPrice * discount;
        } else {
            float ticketPrice = currentTicket.getJourney().getOffPeakPrice();
            return ticketPrice -= ticketPrice * discount;
        }
    }

    // Overloaded method for journeys
    public float calculatePrice(Journey journey, float discount, boolean peak) {
        if (peak) {
            float journeyPrice = journey.getOnPeakPrice();
            return journeyPrice -= journeyPrice * discount;
        } else {
            float journeyPrice = journey.getOffPeakPrice();
            return journeyPrice -= journeyPrice * discount;
        }
    }

    public float calculateRefund(float dailyCap, float todaysTotal) {
        return todaysTotal - dailyCap;
    }

// </editor-fold>
// Methods End
}
