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
    
    public StationSystem GetDepartureDetails()
    {
        // Return departure StationSystem
        // Giving access to data such as the Station peak status, and location
        return lastDepartedStation;
    }
    
    public boolean CheckForPass(Zone zone)
    {
        boolean hasPass = false;
        
        return hasPass;
    }
}
