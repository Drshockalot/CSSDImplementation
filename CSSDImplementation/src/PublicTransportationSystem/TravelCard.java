/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.util.Date;

/**
 *
 * @author JoBa
 */
public class TravelCard {

    private int travelCardID;
    private User user;
    private float balance;
    private TicketList myTickets;
    private Date startDate;
    private Date expiryDate;
    private String cardType;
    private float discount;
    private Pass pass;
    private StationSystem lastDepartedStation;
    private Date lastDepartedTime;
    private float dailyCap;

// Methods Begin
// <editor-fold>
    public int getId() {
        return this.travelCardID;
    }

    public StationSystem GetDepartureDetails() {
        // Return departure StationSystem
        // Giving access to data such as the Station peak status, and location
        return lastDepartedStation;
    }

    public boolean CheckForPass(Zone zone) {
        boolean hasPass = false;

        return hasPass;
    }

    public float GetDiscount() {
        // Return the value of 'discount'
        return this.discount;
    }

    public float GetBalance() {
        // Return the value of 'balance'
        return this.balance;
    }

    public float GetDailyCap() {
        // Return the value of 'dailyCap'
        return this.dailyCap;
    }

    public void SubtractFromBalance(float cost) {
        // Subtract the cost from the balance
        this.balance = this.balance - cost;
    }

    public void SetPass(Pass newPass) {
        this.pass = newPass;
    }

    public void AddFunds(float refundAmount) {
        this.balance = refundAmount;
    }

// </editor-fold>
// Methods End
}
