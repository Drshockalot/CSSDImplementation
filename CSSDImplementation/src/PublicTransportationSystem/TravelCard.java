/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.util.Calendar;
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
    TravelCard(int travelCardID, User user, String cardType, float discount, float dailyCap) {
        this.travelCardID = travelCardID;
        this.user = user;
        this.balance = 0.0f;
        this.myTickets = new TicketList();
        this.startDate = new Date();
        this.expiryDate = getExpiryDate();
        this.cardType = cardType;
        this.discount = discount;
        this.pass = null;
        this.lastDepartedStation = null;
        this.lastDepartedTime = null;
        this.dailyCap = dailyCap;
    }

    public final Date getExpiryDate() {
        Date now = new Date();
        Calendar expiry = Calendar.getInstance();
        expiry.setTime(now);
        expiry.add(Calendar.DATE, 1095);
        return expiry.getTime();
    }

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
        this.balance -= cost;
    }

    public void SetPass(Pass newPass) {
        this.pass = newPass;
    }

    public void AddFunds(float refundAmount) {
        this.balance = refundAmount;
    }

    public boolean checkForPass(Zone arrivingZone, Zone departureZone) {
        return (departureZone.GetName() == null ? this.pass.departureZone().GetName() == null : departureZone.GetName().equals(this.pass.departureZone().GetName()))
                && (this.pass.arrivalZone().GetName() == null ? arrivingZone.GetName() == null : this.pass.arrivalZone().GetName().equals(arrivingZone.GetName()));
    }

    public TicketList userTickets() {
        return this.myTickets;
    }

// </editor-fold>
// Methods End
}
