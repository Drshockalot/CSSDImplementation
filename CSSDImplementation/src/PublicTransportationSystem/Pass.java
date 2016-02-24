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
public class Pass {

    private TypeEnums.PassType passType;
    private final Date expiryDate;
    private Zone departureZone;
    private Zone arrivalZone;

    public Pass(TypeEnums.PassType passTypeEnum) {
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
}
