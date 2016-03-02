/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JoBa
 */
public class Transaction {

// Methods Begin
// <editor-fold>
    // This method will handle the payment of a ticket
    public boolean payForTicket(Ticket currentTicket, TravelCard currentTravelCard) {
        // Create a new instance of 'PaymentManager', this will handle payment calculations
        PaymentManager payManager = new PaymentManager();

        // Get the amount of discount that the user is entitled to
        float discount = currentTravelCard.getDiscount();
        // Get the current balance on the card
        float balance = currentTravelCard.getBalance();
        // Takes the current ticket and applies the discount, returns the result
        float discountedPrice = payManager.calculatePrice(currentTicket, discount);

        float todaysTotal = 0;
        // If the user has enough to pay for the ticket
        if (currentTravelCard.getBalance() > 0) {
            try {
                // Returns the sum of the ticket prices purchased today
                todaysTotal = TravelSystem.getInstance().getTickets().calculateTodaysTotal(discount, currentTravelCard.getUser(), new Date());
            } catch (Throwable ex) {
                Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
            }

            //float todaysTotal = ticketHistory.calculateTodaysTotal(discount, currentTravelCard.getUser(), new Date());
            // Gets the cap for daily transactions
            float dailyCap = currentTravelCard.getDailyCap();

            // After calculating the discount, subtract the amount from the card balance
            currentTravelCard.subtractFromBalance(discountedPrice);
            // User has paid for the ticket, flag it as 'paid'
            currentTicket.setPaid(true);
            // Add the ticket to their tickets
            try {
                TravelSystem.getInstance().getTickets().add(currentTicket);
            } catch (Throwable ex) {
                Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
            }

            // If the total has reached/gone over the daily cap...
            if (todaysTotal >= dailyCap) {
                // Generate a new pass, always going to be a bus and train day pass
                // Assign the proper type of pass
                Pass newPass = PassManager.generatePass(TypeEnums.PassType.BUSANDTRAINDAY);
                // Assign the new pass to the users travel card
                currentTravelCard.setPass(newPass);
                // Calculate how far over the cap 'todaysTotal' is
                float refundAmount = payManager.calculateRefund(dailyCap, todaysTotal);
                // Refund the difference
                currentTravelCard.addFunds(refundAmount);
            }
            // Ticket paid for
            return true;
        } else {
            // Ticket not paid for
            return false;
        }
    }
// </editor-fold>
// Methods End
}
