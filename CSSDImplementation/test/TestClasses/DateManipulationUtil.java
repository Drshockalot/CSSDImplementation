/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Drshockalotz
 */
public class DateManipulationUtil {

    public static Date generateTestExpiryDateFromCreationDate(Date creationDate, int futureDays) {
        Calendar expiry = Calendar.getInstance();
        expiry.setTime(creationDate);
        expiry.add(Calendar.DATE, futureDays);
        return expiry.getTime();
    }

    public static boolean isOnSameDay(Date ticketDate, Date desiredDate) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(ticketDate);
        cal2.setTime(desiredDate);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
    }
}
