/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Contains information on passes, including current departure/arrival zone,
 * type and expiry date
 *
 * @author JoBa
 */
public class Pass implements Serializable {

    private TypeEnums.PassType passType;
    private final Date expiryDate;
    private Zone departureZone;
    private Zone arrivalZone;

    public Pass(TypeEnums.PassType passTypeEnum) {
        // Set up the pass with a type and expiry date
        this.expiryDate = setExpiryDate();
        this.passType = passTypeEnum;
    }

    private Date setExpiryDate() {
        // Sets the expiry to the end of the day
        Date expiry = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(expiry);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 59);
        expiry = calendar.getTime();

        return expiry;
    }

    private void setPassType(TypeEnums.PassType ticketTypeEnum) {
        this.passType = ticketTypeEnum;
    }

    public TypeEnums.PassType passType() {
        return this.passType;
    }

    private Date getExpiryDate() {
        return this.expiryDate;
    }

    public Zone arrivalZone() {
        return this.arrivalZone;
    }

    public Zone departureZone() {
        return this.departureZone;
    }

    public void setArrivalZone(Zone arrival) {
        this.arrivalZone = arrival;
    }

    public void setDepartureZone(Zone departure) {
        this.departureZone = departure;
    }
}
