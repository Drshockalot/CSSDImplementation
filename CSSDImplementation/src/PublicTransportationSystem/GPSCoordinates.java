/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

/**
 *
 * @author Drshockalotz
 */
public class GPSCoordinates {

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
}
