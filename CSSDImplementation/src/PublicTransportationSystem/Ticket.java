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

    /**
     *
     * @param ticketID
     * @param ticketTypeEnum
     * @param journey
     * @param peak
     */
    public Ticket(int ticketID, TypeEnums.TicketType ticketTypeEnum, Journey journey, boolean peak) {
        this.ticketID = ticketID;
        this.theJourney = journey;
        this.purchaseTime = new Date();
        this.ticketType = ticketTypeEnum;
        this.peak = peak;
    }

    public Journey GetJourney() {
        return this.theJourney;
    }

    public TypeEnums.TicketType GetTicketType() {
        return this.ticketType;
    }

    public int GetTicketId() {
        return this.ticketID;
    }

    public Date GetPurchasedTime() {
        return this.purchaseTime;
    }

    public boolean GetIsPaid() {
        return this.paid;
    }

    public void SetPaid(boolean isPaid) {
        this.paid = isPaid;
    }

    public boolean IsPeakTicket(boolean isPaid) {
        return this.peak;
    }
}
