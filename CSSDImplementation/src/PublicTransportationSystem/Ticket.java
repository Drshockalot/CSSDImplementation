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
public class Ticket {

    private final TypeEnums.TicketType ticketType;
    private int ticketID;
    private final Journey theJourney;
    private boolean paid;
    private final String purchaseTime;

    /**
     *
     * @param ticketTypeEnum
     * @param journey
     */
    public Ticket(TypeEnums.TicketType ticketTypeEnum, Journey journey) {
        // this.ticketID = ticketID;  TODO: Needs to be generated
        this.theJourney = journey;
        this.purchaseTime = CurrentDateTime.get();
        this.ticketType = ticketTypeEnum;
    }

    public Journey GetJourney() {
        return this.theJourney;
    }

    public TypeEnums.TicketType GetTicketType() {
        return this.ticketType;
    }
}
