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
        return currentTicket.getJourney().getPrice();
    }

    public float calculateRefund(float dailyCap, float todaysTotal) {
        return todaysTotal - dailyCap;
    }

// </editor-fold>
// Methods End
}
