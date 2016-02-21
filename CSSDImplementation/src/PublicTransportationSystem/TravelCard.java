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
    private SetOfTickets myTickets;
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
        this.myTickets = new SetOfTickets();
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

    public StationSystem getDepartureDetails() {
        // Return departure StationSystem
        // Giving access to data such as the Station peak status, and location
        return lastDepartedStation;
    }

    public boolean checkForActivePass() {
        return this.pass == null;
    }

    public boolean checkForPass(Zone zone) {
        boolean hasPass = false;

        return hasPass;
    }

    public TypeEnums.PassType getPassType() {
        return this.pass.passType();
    }

    public float getDiscount() {
        // Return the value of 'discount'
        return this.discount;
    }

    public float getBalance() {
        // Return the value of 'balance'
        return this.balance;
    }

    public float getDailyCap() {
        // Return the value of 'dailyCap'
        return this.dailyCap;
    }

    public void subtractFromBalance(float cost) {
        // Subtract the cost from the balance
        this.balance -= cost;
    }

    public void setPass(Pass newPass) {
        this.pass = newPass;
    }

    public void addFunds(float refundAmount) {
        this.balance = refundAmount;
    }

    public boolean checkForPass(Zone arrivingZone, Zone departureZone) {
        return (departureZone.getName() == null ? this.pass.departureZone().getName() == null : departureZone.getName().equals(this.pass.departureZone().getName()))
                && (this.pass.arrivalZone().getName() == null ? arrivingZone.getName() == null : this.pass.arrivalZone().getName().equals(arrivingZone.getName()));
    }

    public SetOfTickets userTickets() {
        return this.myTickets;
    }

    public boolean checkForScannedStation() {
        return this.lastDepartedStation == null;
    }

    public void setLastDepartedStationNull() {
        this.lastDepartedStation = null;
        this.lastDepartedTime = null;
    }

    public User getUser() {
        return this.user;
    }
// </editor-fold>
// Methods End
}
