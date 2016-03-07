/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.io.Serializable;

/**
 *
 * @author Drshockalotz
 */
public class GPSCoordinates implements Serializable {

    private static final long serialVersionUID = 186341637222937232L;

    public float longitude;
    public float latitude;

    public GPSCoordinates(float newLongitude, float newLatitude) {
        longitude = newLongitude;
        latitude = newLatitude;
    }

    public float getLongitude() {
        return this.longitude;
    }

    public float getLatitude() {
        return this.latitude;
    }

    @Override
    public String toString() {
        return this.longitude + ", " + this.latitude;
    }
}
