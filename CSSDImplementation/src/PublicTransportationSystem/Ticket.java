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
public class Ticket
{
    private int ticketID;
    private String ticketType;
    private Journey journey;
    private boolean paid;
    private Date purchaseTime;
    
    public Journey GetJourney() {
        return this.journey;
    }
}
