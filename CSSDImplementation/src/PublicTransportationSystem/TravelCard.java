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
    private Date startDate;
    private Date expiryDate;
//    private String cardType;
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
        this.startDate = new Date();
        this.expiryDate = calculateExpiryDate();
//        this.cardType = cardType;
        this.discount = discount;
        this.pass = null;
        this.lastDepartedStation = null;
        this.lastDepartedTime = null;
        this.dailyCap = dailyCap;
    }

    private final Date calculateExpiryDate() {
        Date now = new Date();
        Calendar expiry = Calendar.getInstance();
        expiry.setTime(now);
        expiry.add(Calendar.DATE, 1095);
        return expiry.getTime();
    }

    public Date getExpiryDate() {
        return this.expiryDate;
    }

    public Date getCreationDate() {
        return this.startDate;
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

    public Pass getPass() {
        return this.pass;
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

    public void addFunds(float funds) {
        this.balance += funds;
    }

    public boolean checkForPass(Zone arrivingZone, Zone departureZone) {
        if (this.pass != null) {
            if (this.pass.departureZone() != null && this.pass.arrivalZone() != null) {
                return this.pass.departureZone().getName().equals(departureZone.getName())
                        && this.pass.arrivalZone().getName().equals(arrivingZone.getName());
            }
            return false;
        }
        return false;
    }

    public boolean checkForScannedStation() {
        return this.lastDepartedStation == null;
    }

    public void setLastDepartedStationNull() {
        this.lastDepartedStation = null;
        this.lastDepartedTime = null;
    }

    public void setLastDepartedStation(StationSystem lastScanned) {
        this.lastDepartedStation = lastScanned;
    }

    public User getUser() {
        return this.user;
    }

    public Date getLastDepartedTime() {
        return this.lastDepartedTime;
    }

    public void setLastDepartedTime(Date date) {
        this.lastDepartedTime = date;
    }
// </editor-fold>
// Methods End
}
