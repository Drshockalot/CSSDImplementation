/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author JackMcGlone
 */
public final class CurrentDateTime {

    private CurrentDateTime() {
    }

    public static String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        return dateFormat.format(date);
    }

    public static String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        return dateFormat.format(date);
    }

    public static String getTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();

        return dateFormat.format(date);
    }
}
