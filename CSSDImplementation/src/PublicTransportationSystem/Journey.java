/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

/**
 *
 * @author JoBa
 */
public class Journey {

    private float price;
    private float onPeakPrice;
    private Zone startZone;
    private Zone endZone;

    public Journey(float price, float onPeakPrice, Zone startZone, Zone endZone) {
        this.price = price;
        this.onPeakPrice = onPeakPrice;
        this.startZone = startZone;
        this.endZone = endZone;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Zone getStartZone() {
        return this.startZone;
    }

    public Zone getEndZone() {
        return this.endZone;
    }
}
