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

    private float offPeakPrice;
    private float onPeakPrice;
    private Zone startZone;
    private Zone endZone;

    public Journey(float offPeakPrice, float onPeakPrice, Zone startZone, Zone endZone) {
        this.offPeakPrice = offPeakPrice;
        this.onPeakPrice = onPeakPrice;
        this.startZone = startZone;
        this.endZone = endZone;
    }

    public float getOffPeakPrice() {
        return this.offPeakPrice;
    }

    public float getOnPeakPrice() {
        return this.onPeakPrice;
    }

    public void setOffPeakPrice(float price) {
        this.offPeakPrice = price;
    }

    public void setOnPeakPrice(float price) {
        this.onPeakPrice = price;
    }

    public Zone getStartZone() {
        return this.startZone;
    }

    public Zone getEndZone() {
        return this.endZone;
    }
}
