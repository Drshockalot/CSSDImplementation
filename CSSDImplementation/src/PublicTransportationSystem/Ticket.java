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
public class Ticket {

    private final TypeEnums.TicketType ticketType;
    private final int ticketID;
    private final Journey theJourney;
    private boolean paid;
    private final Date purchaseTime;
    private final boolean peak;
    private int userId;

    /**
     *
     * @param ticketID
     * @param ticketTypeEnum
     * @param journey
     * @param peak
     */
    public Ticket(int ticketID, TypeEnums.TicketType ticketTypeEnum, Journey journey, boolean peak, int userId) {
        this.ticketID = ticketID;
        this.theJourney = journey;
        this.purchaseTime = new Date();
        this.ticketType = ticketTypeEnum;
        this.peak = peak;
        this.userId = userId;
    }

    public Journey getJourney() {
        return this.theJourney;
    }

    public TypeEnums.TicketType getTicketType() {
        return this.ticketType;
    }

    public int getTicketId() {
        return this.ticketID;
    }

    public Date getPurchasedTime() {
        return this.purchaseTime;
    }

    public boolean getIsPaid() {
        return this.paid;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setPaid(boolean isPaid) {
        this.paid = isPaid;
    }

    public boolean isPeakTicket() {
        return this.peak;
    }
}
