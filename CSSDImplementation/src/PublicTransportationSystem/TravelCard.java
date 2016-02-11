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
    
// Methods Begin    
// <editor-fold>
    
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

    public float GetDiscount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public float GetBalance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public float GetDailyCap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void SubtractFromBalance(float discountedPrice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void SetPass(Pass newPass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void AddFunds(float refundAmount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
// </editor-fold>
// Methods End
}
