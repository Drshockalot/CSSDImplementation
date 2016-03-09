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
 * Contains information for travel zones
 *
 * @author JoBa
 */
public class Zone implements Serializable {

    private static final long serialVersionUID = -4313904071667252251L;

    private String name;
    private int id;

    public Zone(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public boolean isPeak() {
        // Construct times for comparison
        Date t = new Date();
        Calendar peakFloor = Calendar.getInstance();
        Calendar peakCeiling = Calendar.getInstance();
        Calendar now = Calendar.getInstance();

        // Determine whether current time is within the boundaries of peak
        now.setTime(t);
        peakFloor.setTime(t);
        peakCeiling.setTime(t);
        peakFloor.set(peakFloor.get(Calendar.YEAR), peakFloor.get(Calendar.MONTH), peakFloor.get(Calendar.DAY_OF_MONTH), 16, 0);
        peakCeiling.set(peakCeiling.get(Calendar.YEAR), peakCeiling.get(Calendar.MONTH), peakCeiling.get(Calendar.DAY_OF_MONTH), 19, 0);
        return (peakFloor.get(Calendar.HOUR) <= now.get(Calendar.HOUR) && peakFloor.get(Calendar.MINUTE) <= now.get(Calendar.MINUTE)
                && peakCeiling.get(Calendar.HOUR) >= now.get(Calendar.HOUR) && peakCeiling.get(Calendar.MINUTE) >= now.get(Calendar.MINUTE));
    }

    @Override
    public String toString() {
        return this.name;
    }

}
