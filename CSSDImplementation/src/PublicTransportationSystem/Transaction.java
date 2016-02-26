/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

/**
 *
 * @author JoBa
 */
public class Transaction {

// Methods Begin
// <editor-fold>
    // This method will handle the payment of a ticket
    public void payForTicket(SetOfTickets ticketHistory, Ticket currentTicket, TravelCard currentTravelCard) {
        // Create a new instance of 'PaymentManager', this will handle payment calculations
        PaymentManager payManager = new PaymentManager();

        // Get the amount of discount that the user is entitled to
        float discount = currentTravelCard.getDiscount();
        // Get the current balance on the card
        float balance = currentTravelCard.getBalance();

        // Takes the current ticket and applies the discount, returns the result
        float discountedPrice = payManager.calculatePrice(currentTicket, discount);
        // Returns the sum of the ticket prices purchased today
        float todaysTotal = ticketHistory.calculateTodaysTotal(discount);
        // Gets the cap for daily transactions
        float dailyCap = currentTravelCard.getDailyCap();
        // After calculating the discount, subtract the amount from the card balance
        currentTravelCard.subtractFromBalance(discountedPrice);

        // If the total has reached/gone over the daily cap...
        if (todaysTotal >= dailyCap) {
            // Generate a new pass
            // TODO: LOOK AT HANDLING DIFFERENT PASSES
            Pass newPass = PassManager.generatePass(TypeEnums.PassType.TRAINDAY);
            // Assign the new pass to the users travel card
            currentTravelCard.setPass(newPass);
            // Calculate how far over the cap 'todaysTotal' is
            float refundAmount = payManager.calculateRefund(dailyCap, todaysTotal);
            // Refund the difference
            currentTravelCard.addFunds(refundAmount);
        }
    }
// </editor-fold>
// Methods End
}
